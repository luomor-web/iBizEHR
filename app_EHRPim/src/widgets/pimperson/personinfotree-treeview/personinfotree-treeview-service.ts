import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PIMPERSONService from '@/service/pimperson/pimperson-service';
import PERSONINFOTREEModel from './personinfotree-treeview-model';
import CodeListService from '@service/app/codelist-service';
import i18n from '@/locale';
import ORMORGService from '@service/ormorg/ormorg-service';
import ORMORGSECTORService from '@service/ormorgsector/ormorgsector-service';


/**
 * PERSONINFOTREE 部件服务对象
 *
 * @export
 * @class PERSONINFOTREEService
 */
export default class PERSONINFOTREEService extends ControlService {

    /**
     * 人员信息服务对象
     *
     * @type {PIMPERSONService}
     * @memberof PERSONINFOTREEService
     */
    public appEntityService: PIMPERSONService = new PIMPERSONService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof PERSONINFOTREEService
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of PERSONINFOTREEService.
     * 
     * @param {*} [opts={}]
     * @memberof PERSONINFOTREEService
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new PERSONINFOTREEModel();
    }


    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof PERSONINFOTREEService
     */
    public codeListService:CodeListService = new CodeListService({ $store: this.getStore() });


    /**
     * 组织管理服务对象
     *
     * @type {ORMORGService}
     * @memberof PERSONINFOTREEService
     */
    public ormorgService: ORMORGService = new ORMORGService({ $store: this.getStore() });

    /**
     * 部门管理服务对象
     *
     * @type {ORMORGSECTORService}
     * @memberof PERSONINFOTREEService
     */
    public ormorgsectorService: ORMORGSECTORService = new ORMORGSECTORService({ $store: this.getStore() });

    /**
     * 节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
    private TREENODE_SEPARATOR: string = ';';

    /**
     * 根组织节点节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	private TREENODE_ORMORGINFO: string = 'ORMORGINFO';

    /**
     * 子组织节点节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	private TREENODE_SUBORMORGINFO: string = 'SUBORMORGINFO';

    /**
     * 子子组织节点节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	private TREENODE_SUBSUBORMORGINFO: string = 'SubSubORMORGINFO';

    /**
     * 子部门节点节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	private TREENODE_ORMORGSECTOR: string = 'ORMORGSECTOR';

    /**
     * 默认根节点节点分隔符号
     *
     * @private
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	private TREENODE_ROOT: string = 'ROOT';

    /**
     * 获取节点数据
     *
     * @param {string} action
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
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

        if (Object.is(strNodeType, this.TREENODE_ORMORGINFO)) {
            await this.fillOrmorginfoNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_SUBORMORGINFO)) {
            await this.fillSubormorginfoNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_SUBSUBORMORGINFO)) {
            await this.fillSubsubormorginfoNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_ORMORGSECTOR)) {
            await this.fillOrmorgsectorNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_ROOT)) {
            await this.fillRootNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        return Promise.resolve({ status: 500, data: { title: '失败', message: `树节点${strTreeNodeId}标识无效` } });
    }

    /**
     * 填充 树视图节点[根组织节点]
     *
     * @private
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private fillOrmorginfoNodes(context:any={},filter: any, list: any[]): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
            Object.assign(searchFilter, { total: false });
            Object.assign(searchFilter, { query: filter.srfnodefilter });
            let bFirst: boolean = true;
            let records: any[] = [];
            try {
                this.searchOrmorginfo(context, searchFilter, filter).then((records:any) =>{
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
                        let strNodeId: string = 'ORMORGINFO';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: true });
                        Object.assign(treeNode, { leaf: false });
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
    private searchOrmorginfo(context:any={}, searchFilter: any, filter: any): Promise<any> {
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
     * 填充 树视图节点[根组织节点]子节点
     *
     * @private
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private async fillOrmorginfoNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充子部门节点
			await this.fillOrmorgsectorNodes(context, filter, list);
			// 填充子组织节点
			await this.fillSubormorginfoNodes(context, filter, list);
		} else {
			// 填充子部门节点
			await this.fillOrmorgsectorNodes(context, filter, list);
			// 填充子组织节点
			await this.fillSubormorginfoNodes(context, filter, list);
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
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private fillSubormorginfoNodes(context:any={},filter: any, list: any[]): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
            if (Object.is(filter.strNodeType, this.TREENODE_ORMORGINFO)) {
                Object.assign(searchFilter, { n_porgid_eq: filter.nodeid });
            }

            Object.assign(searchFilter, { total: false });
            Object.assign(searchFilter, { query: filter.srfnodefilter });
            let bFirst: boolean = true;
            let records: any[] = [];
            try {
                this.searchSubormorginfo(context, searchFilter, filter).then((records:any) =>{
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
                        let strNodeId: string = 'SUBORMORGINFO';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: false });
                        Object.assign(treeNode, { navfilter: "n_ormorgid_eq" });
                        Object.assign(treeNode, { navparams: '{"n_zgcode_eq":"10","nodeid":"%NODEID%"}' });
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
    private searchSubormorginfo(context:any={}, searchFilter: any, filter: any): Promise<any> {
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
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private async fillSubormorginfoNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充子部门节点
			await this.fillOrmorgsectorNodes(context, filter, list);
			// 填充子子组织节点
			await this.fillSubsubormorginfoNodes(context, filter, list);
		} else {
			// 填充子部门节点
			await this.fillOrmorgsectorNodes(context, filter, list);
			// 填充子子组织节点
			await this.fillSubsubormorginfoNodes(context, filter, list);
		}
	}

    /**
     * 填充 树视图节点[子子组织节点]
     *
     * @private
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private fillSubsubormorginfoNodes(context:any={},filter: any, list: any[]): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
            if (Object.is(filter.strNodeType, this.TREENODE_SUBORMORGINFO)) {
                Object.assign(searchFilter, { n_porgid_eq: filter.nodeid });
            }

            Object.assign(searchFilter, { total: false });
            Object.assign(searchFilter, { query: filter.srfnodefilter });
            let bFirst: boolean = true;
            let records: any[] = [];
            try {
                this.searchSubsubormorginfo(context, searchFilter, filter).then((records:any) =>{
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
                        let strNodeId: string = 'SubSubORMORGINFO';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: false });
                        Object.assign(treeNode, { navparams: '{"n_zgcode_eq":"10","nodeid":"%NODEID%"}' });
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
    private searchSubsubormorginfo(context:any={}, searchFilter: any, filter: any): Promise<any> {
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
     * 填充 树视图节点[子子组织节点]子节点
     *
     * @private
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private async fillSubsubormorginfoNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充子部门节点
			await this.fillOrmorgsectorNodes(context, filter, list);
		} else {
			// 填充子部门节点
			await this.fillOrmorgsectorNodes(context, filter, list);
		}
	}

    /**
     * 填充 树视图节点[子部门节点]
     *
     * @private
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private fillOrmorgsectorNodes(context:any={},filter: any, list: any[]): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
            Object.assign(searchFilter, { total: false });
            let bFirst: boolean = true;
            let records: any[] = [];
            try {
                this.searchOrmorgsector(context, searchFilter, filter).then((records:any) =>{
                    if(records && records.length >0){
                        records.forEach((entity: any) => {
                        let treeNode: any = {};
                        // 整理context
                        let strId: string = entity.orgsectorid;
                        let strText: string = entity.shortname;
                        Object.assign(treeNode,{srfparentdename:'ORMORGSECTOR',srfparentkey:entity.orgsectorid});
                        Object.assign(treeNode,{srfappctxkey:'ormorgsector'});
                        Object.assign(treeNode,{srfappctx:{'ormorgsector':strId}});
                        Object.assign(treeNode,{'ormorgsector':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'ORMORGSECTOR';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: true });
                        Object.assign(treeNode, { navparams: '{"n_zgcode_eq":"10","nodeid":"%NODEID%"}' });
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
    private searchOrmorgsector(context:any={}, searchFilter: any, filter: any): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            if(!searchFilter.page){
                Object.assign(searchFilter,{page:0});
            }
            if(!searchFilter.size){
                Object.assign(searchFilter,{size:1000});
            }
            Object.assign(searchFilter,{sort: 'ordervalue,asc'})
            const _appEntityService: any = this.ormorgsectorService;
            let list: any[] = [];
            if (_appEntityService['FetchPimpersonInfoOrgsector'] && _appEntityService['FetchPimpersonInfoOrgsector'] instanceof Function) {
                const response: Promise<any> = _appEntityService['FetchPimpersonInfoOrgsector'](context, searchFilter, false);
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
     * 填充 树视图节点[子部门节点]子节点
     *
     * @private
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private async fillOrmorgsectorNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
		} else {
		}
	}

    /**
     * 填充 树视图节点[默认根节点]
     *
     * @private
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private fillRootNodes(context:any={},filter: any, list: any[]): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            let treeNode: any = {};
            Object.assign(treeNode, { text: 'entities.pimperson.personinfotree_treeview.nodes.root' });
            Object.assign(treeNode, { isUseLangRes: true });
            Object.assign(treeNode,{srfappctx:context});
            Object.assign(treeNode, { srfmajortext: treeNode.text });
            let strNodeId: string = 'ROOT';

            Object.assign(treeNode, { srfkey: 'root' });
            strNodeId += this.TREENODE_SEPARATOR;
            strNodeId += 'root';

            Object.assign(treeNode, { id: strNodeId });

            Object.assign(treeNode, { expanded: filter.isAutoexpand });
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
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    private async fillRootNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充根组织节点
			await this.fillOrmorginfoNodes(context, filter, list);
		} else {
			// 填充根组织节点
			await this.fillOrmorginfoNodes(context, filter, list);
		}
	}


    /**
     * 处理代码表返回数据(树状结构)
     * 
     * @param result 返回数组
     * @param context 应用上下文
     * @param callBack 回调
     * @memberof PERSONINFOTREEService
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
     * @memberof PERSONINFOTREEService
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
     * @memberof PERSONINFOTREEService
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