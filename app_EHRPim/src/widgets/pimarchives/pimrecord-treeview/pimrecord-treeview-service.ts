import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PIMARCHIVESService from '@/service/pimarchives/pimarchives-service';
import PIMRecordModel from './pimrecord-treeview-model';
import CodeListService from '@service/app/codelist-service';
import i18n from '@/locale';
import ORMORGService from '@service/ormorg/ormorg-service';


/**
 * PIMRecord 部件服务对象
 *
 * @export
 * @class PIMRecordService
 */
export default class PIMRecordService extends ControlService {

    /**
     * 档案信息服务对象
     *
     * @type {PIMARCHIVESService}
     * @memberof PIMRecordService
     */
    public appEntityService: PIMARCHIVESService = new PIMARCHIVESService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof PIMRecordService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of PIMRecordService.
     * 
     * @param {*} [opts={}]
     * @memberof PIMRecordService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new PIMRecordModel();
    }


    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof PIMRecordService
     */
    public codeListService:CodeListService = new CodeListService({ $store: this.getStore() });


    /**
     * 组织管理服务对象
     *
     * @type {ORMORGService}
     * @memberof PIMRecordService
     */
    public ormorgService: ORMORGService = new ORMORGService({ $store: this.getStore() });

    /**
     * 节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PIMRecordService
     */
    private TREENODE_SEPARATOR: string = ';';

    /**
     * 默认根节点节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PIMRecordService
     */
	private TREENODE_ROOT: string = 'ROOT';

    /**
     * 子组织节点节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PIMRecordService
     */
	private TREENODE_SUBORG: string = 'SubORG';

    /**
     * 根节点组织节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PIMRecordService
     */
	private TREENODE_ORMORG: string = 'ORMORG';

    /**
     * 获取节点数据
     *
     * @param {string} action
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PIMRecordService
     */
    @Errorlog
    public async getNodes(context:any = {},data: any = {}, isloading?: boolean): Promise<any> {
        let { srfparentkey, srfcat, srfnodeid, srfnodefilter, query }: { srfparentkey: string, srfcat: string, srfnodeid: string, srfnodefilter: string, query:string } = data;
        srfnodefilter = query ? query : srfnodefilter;
        let list: any[] = [];
        let filter: any = {};


        if (!srfnodeid || Object.is(srfnodeid, '#')) {
            srfnodeid = this.TREENODE_ROOT;
        }

        let strTreeNodeId: string = srfnodeid;
        let strRealNodeId: string = '';
        let bRootSelect: boolean = false;
        let strNodeType: string | null = null;
        let strRootSelectNode: string = '';

        if (Object.is(strTreeNodeId, this.TREENODE_ROOT)) {
            strNodeType = this.TREENODE_ROOT;
            if (srfparentkey) {
                strRealNodeId = srfparentkey;
            }
        } else {
            let nPos = strTreeNodeId.indexOf(this.TREENODE_SEPARATOR);
            if (nPos === -1) {
                return Promise.reject({ status: 500, data: { title: '失败', message: `树节点${strTreeNodeId}标识无效` } });
            }
            strNodeType = strTreeNodeId.substring(0, nPos);
			strRealNodeId = strTreeNodeId.substring(nPos + 1);
        }

        Object.assign(filter,
            {
                srfparentkey: srfparentkey,
                srfcat: srfcat,
                srfnodefilter: srfnodefilter,
                strRealNodeId: strRealNodeId,
                srfnodeid: srfnodeid,
                strNodeType: strNodeType
            }
        );

        // 分解节点标识
        let nodeid: string[] = strRealNodeId.split(this.TREENODE_SEPARATOR);
        for (let i = 0; i < nodeid.length; i++) {
            switch (i) {
                case 0:
                    Object.assign(filter, { nodeid: nodeid[0] });
                    break;
                case 1:
                    Object.assign(filter, { nodeid2: nodeid[1] });
                    break;
                case 2:
                    Object.assign(filter, { nodeid3: nodeid[2] });
                    break;
                case 3:
                    Object.assign(filter, { nodeid4: nodeid[3] });
                    break;
                default:
                    break;
            }
        }

        if (Object.is(strNodeType, this.TREENODE_ROOT)) {
            await this.fillRootNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_SUBORG)) {
            await this.fillSuborgNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_ORMORG)) {
            await this.fillOrmorgNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        return Promise.resolve({ status: 500, data: { title: '失败', message: `树节点${strTreeNodeId}标识无效` } });
    }

    /**
     * 填充 树视图节点[默认根节点]
     *
     * @private
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PIMRecordService
     */
    @Errorlog
    private fillRootNodes(context:any={},filter: any, list: any[]): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            let treeNode: any = {};
            Object.assign(treeNode, { text: 'entities.pimarchives.pimrecord_treeview.nodes.root' });
            Object.assign(treeNode, { isUseLangRes: true });
            Object.assign(treeNode,{srfappctx:context});
            Object.assign(treeNode, { srfmajortext: treeNode.text });
            let strNodeId: string = 'ROOT';

            Object.assign(treeNode, { srfkey: 'root' });
            strNodeId += this.TREENODE_SEPARATOR;
            strNodeId += 'root';

            Object.assign(treeNode, { id: strNodeId });

            Object.assign(treeNode, { expanded: true });
            Object.assign(treeNode, { leaf: false });
            Object.assign(treeNode, { navparams: '{}' });
            Object.assign(treeNode, { nodeid: treeNode.srfkey });
            Object.assign(treeNode, { nodeid2: filter.strRealNodeId });
            list.push(treeNode);
            resolve(list);
        });
	}

    /**
     * 填充 树视图节点[默认根节点]子节点
     *
     * @private
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PIMRecordService
     */
    @Errorlog
    private async fillRootNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充根节点组织
			await this.fillOrmorgNodes(context, filter, list);
		} else {
			// 填充根节点组织
			await this.fillOrmorgNodes(context, filter, list);
		}
	}

    /**
     * 填充 树视图节点[子组织节点]
     *
     * @private
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PIMRecordService
     */
    @Errorlog
    private fillSuborgNodes(context:any={},filter: any, list: any[]): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
            if (Object.is(filter.strNodeType, this.TREENODE_SUBORG)) {
                Object.assign(searchFilter, { n_porgid_eq: filter.nodeid });
            }

            if (Object.is(filter.strNodeType, this.TREENODE_ORMORG)) {
                Object.assign(searchFilter, { n_porgid_eq: filter.nodeid });
            }

            Object.assign(searchFilter, { total: false });
            Object.assign(searchFilter, { query: filter.srfnodefilter });
            let bFirst: boolean = true;
            let records: any[] = [];
            try {
                this.searchSuborg(context, searchFilter, filter).then((records:any) =>{
                    if(records && records.length >0){
                        records.forEach((entity: any) => {
                        let treeNode: any = {};
                        // 整理context
                        let strId: string = entity.orgid;
                        let strText: string = entity.shortname;
                        Object.assign(treeNode,{srfparentdename:'ORMORG',srfparentkey:entity.orgid});
                        Object.assign(treeNode,{srfappctxkey:'ormorg'});
                        Object.assign(treeNode,{srfappctx:{'ormorg':strId}});
                        Object.assign(treeNode,{'ormorg':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'SubORG';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: false });
                        Object.assign(treeNode, { navfilter: "n_ormorgid_eq" });
                        Object.assign(treeNode, { navparams: '{}' });
                        Object.assign(treeNode, { nodeid: treeNode.srfkey });
                        Object.assign(treeNode, { nodeid2: filter.strRealNodeId });
                        list.push(treeNode);
                        resolve(list);
                        bFirst = false;
                    });
                    }else{
                        resolve(list);
                    }
                });
            } catch (error) {
                console.error(error);
            }
        });

	}

    /**
     * 获取查询集合
     *
     * @private
     * @param {any{}} context     
     * @param {*} searchFilter
     * @param {*} filter
     * @returns {any[]}
     * @memberof TestEnetityDatasService
     */
    @Errorlog
    private searchSuborg(context:any={}, searchFilter: any, filter: any): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            if(!searchFilter.page){
                Object.assign(searchFilter,{page:0});
            }
            if(!searchFilter.size){
                Object.assign(searchFilter,{size:1000});
            }
            Object.assign(searchFilter,{sort: 'px,asc'})
            const _appEntityService: any = this.ormorgService;
            let list: any[] = [];
            if (_appEntityService['FetchCurChild'] && _appEntityService['FetchCurChild'] instanceof Function) {
                const response: Promise<any> = _appEntityService['FetchCurChild'](context, searchFilter, false);
                response.then((response: any) => {
                    if (!response.status || response.status !== 200) {
                        reject("数据集异常!");
                    }
                    const data: any = response.data;
                    if (Object.keys(data).length > 0) {
                        list = JSON.parse(JSON.stringify(data));
                        resolve(list);
                    } else {
                        resolve([]);
                    }
                }).catch((response: any) => {
                    reject("数据集异常!");
                });
            }
        })
    }

    /**
     * 填充 树视图节点[子组织节点]子节点
     *
     * @private
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PIMRecordService
     */
    @Errorlog
    private async fillSuborgNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充子组织节点
			await this.fillSuborgNodes(context, filter, list);
		} else {
			// 填充子组织节点
			await this.fillSuborgNodes(context, filter, list);
		}
	}

    /**
     * 填充 树视图节点[根节点组织]
     *
     * @private
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PIMRecordService
     */
    @Errorlog
    private fillOrmorgNodes(context:any={},filter: any, list: any[]): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
            Object.assign(searchFilter, { total: false });
            Object.assign(searchFilter, { query: filter.srfnodefilter });
            let bFirst: boolean = true;
            let records: any[] = [];
            try {
                this.searchOrmorg(context, searchFilter, filter).then((records:any) =>{
                    if(records && records.length >0){
                        records.forEach((entity: any) => {
                        let treeNode: any = {};
                        // 整理context
                        let strId: string = entity.orgid;
                        let strText: string = entity.shortname;
                        Object.assign(treeNode,{srfparentdename:'ORMORG',srfparentkey:entity.orgid});
                        Object.assign(treeNode,{srfappctxkey:'ormorg'});
                        Object.assign(treeNode,{srfappctx:{'ormorg':strId}});
                        Object.assign(treeNode,{'ormorg':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'ORMORG';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: true });
                        Object.assign(treeNode, { leaf: false });
                        Object.assign(treeNode, { navfilter: "n_ormorgid_eq" });
                        Object.assign(treeNode, { navparams: '{}' });
                        Object.assign(treeNode, { nodeid: treeNode.srfkey });
                        Object.assign(treeNode, { nodeid2: filter.strRealNodeId });
                        list.push(treeNode);
                        resolve(list);
                        bFirst = false;
                    });
                    }else{
                        resolve(list);
                    }
                });
            } catch (error) {
                console.error(error);
            }
        });

	}

    /**
     * 获取查询集合
     *
     * @private
     * @param {any{}} context     
     * @param {*} searchFilter
     * @param {*} filter
     * @returns {any[]}
     * @memberof TestEnetityDatasService
     */
    @Errorlog
    private searchOrmorg(context:any={}, searchFilter: any, filter: any): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            if(!searchFilter.page){
                Object.assign(searchFilter,{page:0});
            }
            if(!searchFilter.size){
                Object.assign(searchFilter,{size:1000});
            }
            Object.assign(searchFilter,{sort: 'px,asc'})
            const _appEntityService: any = this.ormorgService;
            let list: any[] = [];
            if (_appEntityService['FetchCurPorg'] && _appEntityService['FetchCurPorg'] instanceof Function) {
                const response: Promise<any> = _appEntityService['FetchCurPorg'](context, searchFilter, false);
                response.then((response: any) => {
                    if (!response.status || response.status !== 200) {
                        reject("数据集异常!");
                    }
                    const data: any = response.data;
                    if (Object.keys(data).length > 0) {
                        list = JSON.parse(JSON.stringify(data));
                        resolve(list);
                    } else {
                        resolve([]);
                    }
                }).catch((response: any) => {
                    reject("数据集异常!");
                });
            }
        })
    }

    /**
     * 填充 树视图节点[根节点组织]子节点
     *
     * @private
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PIMRecordService
     */
    @Errorlog
    private async fillOrmorgNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充子组织节点
			await this.fillSuborgNodes(context, filter, list);
		} else {
			// 填充子组织节点
			await this.fillSuborgNodes(context, filter, list);
		}
	}


    /**
     * 处理代码表返回数据(树状结构)
     * 
     * @param result 返回数组
     * @param context 应用上下文
     * @param callBack 回调
     * @memberof PIMRecordService
     */
    public handleDataSet(result:Array<any>,context:any,callBack:any){
        let list:Array<any> = [];
        if(result.length === 0){
            return list;
        }
        result.forEach((codeItem:any) =>{
            if(!codeItem.pvalue){
                let valueField:string = codeItem.value;
                this.setChildCodeItems(valueField,result,codeItem);
                list.push(codeItem);
            }
        })
        this.setNodeData(list,context,callBack);
        return list;
    }

    /**
     * 处理非根节点数据
     * 
     * @param result 返回数组
     * @param context 应用上下文
     * @param callBack 回调
     * @memberof PIMRecordService
     */
    public setChildCodeItems(pValue:string,result:Array<any>,codeItem:any){
        result.forEach((item:any) =>{
            if(item.pvalue == pValue){
                let valueField:string = item.value;
                this.setChildCodeItems(valueField,result,item);
                if(!codeItem.children){
                    codeItem.children = [];
                }
                codeItem.children.push(item);
            }
        })
    }

    /**
     * 设置节点UI数据
     * 
     * @param result 返回数组
     * @param context 应用上下文
     * @param callBack 回调
     * @memberof PIMRecordService
     */
    public setNodeData(result:Array<any>,context:any,callBack:any){
        result.forEach((item:any) =>{
            if(item.children){
                item.leaf = false;
                this.setNodeData(item.children,context,callBack);
            }else{
                item.leaf = true;
            }
            callBack(context,item);
        })
    }

}