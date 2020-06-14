import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import OrmOrgService from '@/service/orm-org/orm-org-service';
import ORMORGTree2Model from './ormorgtree2-treeview-model';
import CodeListService from '@service/app/codelist-service';
import i18n from '@/locale';
import OrmOrgsectorService from '@service/orm-orgsector/orm-orgsector-service';


/**
 * ORMORGTree2 部件服务对象
 *
 * @export
 * @class ORMORGTree2Service
 */
export default class ORMORGTree2Service extends ControlService {

    /**
     * 组织管理服务对象
     *
     * @type {OrmOrgService}
     * @memberof ORMORGTree2Service
     */
    public appEntityService: OrmOrgService = new OrmOrgService({ $store: this.getStore() });

    /**
     * 设置从数据模式
     *
     * @type {boolean}
     * @memberof ORMORGTree2Service
     */
    public setTempMode(){
        this.isTempMode = false;
    }

    /**
     * Creates an instance of ORMORGTree2Service.
     * 
     * @param {*} [opts={}]
     * @memberof ORMORGTree2Service
     */
    constructor(opts: any = {}) {
        super(opts);
        this.model = new ORMORGTree2Model();
    }


    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof ORMORGTree2Service
     */
    public codeListService:CodeListService = new CodeListService({ $store: this.getStore() });


    /**
     * 部门管理服务对象
     *
     * @type {OrmOrgsectorService}
     * @memberof ORMORGTree2Service
     */
    public ormorgsectorService: OrmOrgsectorService = new OrmOrgsectorService({ $store: this.getStore() });

    /**
     * 节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof ORMORGTree2Service
     */
    public TREENODE_SEPARATOR: string = ';';

    /**
     * 一级组织节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof ORMORGTree2Service
     */
	public TREENODE_ORMORG: string = 'ORMORG';

    /**
     * 三级组织节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof ORMORGTree2Service
     */
	public TREENODE_SUBSUBORG: string = 'SubSubORG';

    /**
     * 二级组织节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof ORMORGTree2Service
     */
	public TREENODE_SUBORG: string = 'SubORG';

    /**
     * 组织部门节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof ORMORGTree2Service
     */
	public TREENODE_SUBORMORGSECTOR: string = 'SubORMORGSECTOR';

    /**
     * 根节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof ORMORGTree2Service
     */
	public TREENODE_ROOT: string = 'ROOT';

    /**
     * 获取节点数据
     *
     * @param {string} action
     * @param {*} [data={}]
     * @param {boolean} [isloading]
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
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
                strNodeType: strNodeType,
                viewparams: JSON.parse(JSON.stringify(data)).viewparams
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

        if (Object.is(strNodeType, this.TREENODE_ORMORG)) {
            await this.fillOrmorgNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_SUBSUBORG)) {
            await this.fillSubsuborgNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_SUBORG)) {
            await this.fillSuborgNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_SUBORMORGSECTOR)) {
            await this.fillSubormorgsectorNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        if (Object.is(strNodeType, this.TREENODE_ROOT)) {
            await this.fillRootNodeChilds(context,filter, list);
            return Promise.resolve({ status: 200, data: list });
        }
        return Promise.resolve({ status: 500, data: { title: '失败', message: `树节点${strTreeNodeId}标识无效` } });
    }

    /**
     * 填充 树视图节点[一级组织节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public fillOrmorgNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
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
                        Object.assign(treeNode,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid});
                        let tempContext:any = JSON.parse(JSON.stringify(context));
                        Object.assign(tempContext,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid,ormorg:strId})
                        Object.assign(treeNode,{srfappctx:tempContext});
                        Object.assign(treeNode,{'ormorg':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'ORMORG';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { iconcls: 'copy' });
                        Object.assign(treeNode, { expanded: true });
                        Object.assign(treeNode, { leaf: false });
                        Object.assign(treeNode, { navfilter: "n_porgid_eq" });
                        Object.assign(treeNode, { curData: entity });
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
     * @public
     * @param {any{}} context     
     * @param {*} searchFilter
     * @param {*} filter
     * @returns {any[]}
     * @memberof TestEnetityDatasService
     */
    @Errorlog
    public searchOrmorg(context:any={}, searchFilter: any, filter: any): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            if(filter.viewparams){
                Object.assign(searchFilter,filter.viewparams);
            }
            if(!searchFilter.page){
                Object.assign(searchFilter,{page:0});
            }
            if(!searchFilter.size){
                Object.assign(searchFilter,{size:1000});
            }
            if(context && context.srfparentdename){
                Object.assign(searchFilter,{srfparentdename:JSON.parse(JSON.stringify(context)).srfparentdename});
            }
            if(context && context.srfparentkey){
                Object.assign(searchFilter,{srfparentkey:JSON.parse(JSON.stringify(context)).srfparentkey});
            }
            Object.assign(searchFilter,{sort: 'px,asc'})
            const _appEntityService: any = this.appEntityService;
            let list: any[] = [];
            if (_appEntityService['FetchCurPorg'] && _appEntityService['FetchCurPorg'] instanceof Function) {
                const response: Promise<any> = _appEntityService['FetchCurPorg'](context, searchFilter, false);
                response.then((response: any) => {
                    if (!response.status || response.status !== 200) {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchCurPorg数据集异常!');
                    }
                    const data: any = response.data;
                    if (Object.keys(data).length > 0) {
                        list = JSON.parse(JSON.stringify(data));
                        resolve(list);
                    } else {
                        resolve([]);
                    }
                }).catch((response: any) => {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchCurPorg数据集异常!');
                });
            }
        })
    }

    /**
     * 填充 树视图节点[一级组织节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public async fillOrmorgNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充二级组织节点
            let SuborgRsNavContext:any = {};
            let SuborgRsNavParams:any = {};
            let SuborgRsParams:any = {};
			await this.fillSuborgNodes(context, filter, list ,SuborgRsNavContext,SuborgRsNavParams,SuborgRsParams);
		} else {
			// 填充二级组织节点
            let SuborgRsNavContext:any = {};
            let SuborgRsNavParams:any = {};
            let SuborgRsParams:any = {};
			await this.fillSuborgNodes(context, filter, list ,SuborgRsNavContext,SuborgRsNavParams,SuborgRsParams);
		}
	}

    /**
     * 填充 树视图节点[三级组织节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public fillSubsuborgNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
            if (Object.is(filter.strNodeType, this.TREENODE_SUBORG)) {
                Object.assign(searchFilter, { n_porgid_eq: filter.nodeid });
            }

            Object.assign(searchFilter, { total: false });
            Object.assign(searchFilter, { query: filter.srfnodefilter });
            let bFirst: boolean = true;
            let records: any[] = [];
            try {
                this.searchSubsuborg(context, searchFilter, filter).then((records:any) =>{
                    if(records && records.length >0){
                        records.forEach((entity: any) => {
                        let treeNode: any = {};
                        // 整理context
                        let strId: string = entity.orgid;
                        let strText: string = entity.shortname;
                        Object.assign(treeNode,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid});
                        let tempContext:any = JSON.parse(JSON.stringify(context));
                        Object.assign(tempContext,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid,ormorg:strId})
                        Object.assign(treeNode,{srfappctx:tempContext});
                        Object.assign(treeNode,{'ormorg':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'SubSubORG';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { iconcls: 'copy' });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: false });
                        Object.assign(treeNode, { navfilter: "n_orgid_eq" });
                        Object.assign(treeNode, { curData: entity });
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
     * @public
     * @param {any{}} context     
     * @param {*} searchFilter
     * @param {*} filter
     * @returns {any[]}
     * @memberof TestEnetityDatasService
     */
    @Errorlog
    public searchSubsuborg(context:any={}, searchFilter: any, filter: any): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            if(filter.viewparams){
                Object.assign(searchFilter,filter.viewparams);
            }
            if(!searchFilter.page){
                Object.assign(searchFilter,{page:0});
            }
            if(!searchFilter.size){
                Object.assign(searchFilter,{size:1000});
            }
            if(context && context.srfparentdename){
                Object.assign(searchFilter,{srfparentdename:JSON.parse(JSON.stringify(context)).srfparentdename});
            }
            if(context && context.srfparentkey){
                Object.assign(searchFilter,{srfparentkey:JSON.parse(JSON.stringify(context)).srfparentkey});
            }
            Object.assign(searchFilter,{sort: 'px,asc'})
            const _appEntityService: any = this.appEntityService;
            let list: any[] = [];
            if (_appEntityService['FetchCurChild'] && _appEntityService['FetchCurChild'] instanceof Function) {
                const response: Promise<any> = _appEntityService['FetchCurChild'](context, searchFilter, false);
                response.then((response: any) => {
                    if (!response.status || response.status !== 200) {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchCurChild数据集异常!');
                    }
                    const data: any = response.data;
                    if (Object.keys(data).length > 0) {
                        list = JSON.parse(JSON.stringify(data));
                        resolve(list);
                    } else {
                        resolve([]);
                    }
                }).catch((response: any) => {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchCurChild数据集异常!');
                });
            }
        })
    }

    /**
     * 填充 树视图节点[三级组织节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public async fillSubsuborgNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充组织部门节点
            let SubormorgsectorRsNavContext:any = {};
            let SubormorgsectorRsNavParams:any = {};
            let SubormorgsectorRsParams:any = {};
			await this.fillSubormorgsectorNodes(context, filter, list ,SubormorgsectorRsNavContext,SubormorgsectorRsNavParams,SubormorgsectorRsParams);
		} else {
			// 填充组织部门节点
            let SubormorgsectorRsNavContext:any = {};
            let SubormorgsectorRsNavParams:any = {};
            let SubormorgsectorRsParams:any = {};
			await this.fillSubormorgsectorNodes(context, filter, list ,SubormorgsectorRsNavContext,SubormorgsectorRsNavParams,SubormorgsectorRsParams);
		}
	}

    /**
     * 填充 树视图节点[二级组织节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public fillSuborgNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
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
                        Object.assign(treeNode,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid});
                        let tempContext:any = JSON.parse(JSON.stringify(context));
                        Object.assign(tempContext,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid,ormorg:strId})
                        Object.assign(treeNode,{srfappctx:tempContext});
                        Object.assign(treeNode,{'ormorg':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'SubORG';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { iconcls: 'copy' });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: false });
                        Object.assign(treeNode, { navfilter: "n_porgid_eq" });
                        Object.assign(treeNode, { curData: entity });
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
     * @public
     * @param {any{}} context     
     * @param {*} searchFilter
     * @param {*} filter
     * @returns {any[]}
     * @memberof TestEnetityDatasService
     */
    @Errorlog
    public searchSuborg(context:any={}, searchFilter: any, filter: any): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            if(filter.viewparams){
                Object.assign(searchFilter,filter.viewparams);
            }
            if(!searchFilter.page){
                Object.assign(searchFilter,{page:0});
            }
            if(!searchFilter.size){
                Object.assign(searchFilter,{size:1000});
            }
            if(context && context.srfparentdename){
                Object.assign(searchFilter,{srfparentdename:JSON.parse(JSON.stringify(context)).srfparentdename});
            }
            if(context && context.srfparentkey){
                Object.assign(searchFilter,{srfparentkey:JSON.parse(JSON.stringify(context)).srfparentkey});
            }
            Object.assign(searchFilter,{sort: 'px,asc'})
            const _appEntityService: any = this.appEntityService;
            let list: any[] = [];
            if (_appEntityService['FetchCurChild'] && _appEntityService['FetchCurChild'] instanceof Function) {
                const response: Promise<any> = _appEntityService['FetchCurChild'](context, searchFilter, false);
                response.then((response: any) => {
                    if (!response.status || response.status !== 200) {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchCurChild数据集异常!');
                    }
                    const data: any = response.data;
                    if (Object.keys(data).length > 0) {
                        list = JSON.parse(JSON.stringify(data));
                        resolve(list);
                    } else {
                        resolve([]);
                    }
                }).catch((response: any) => {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchCurChild数据集异常!');
                });
            }
        })
    }

    /**
     * 填充 树视图节点[二级组织节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public async fillSuborgNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充三级组织节点
            let SubsuborgRsNavContext:any = {};
            let SubsuborgRsNavParams:any = {};
            let SubsuborgRsParams:any = {};
			await this.fillSubsuborgNodes(context, filter, list ,SubsuborgRsNavContext,SubsuborgRsNavParams,SubsuborgRsParams);
		} else {
			// 填充三级组织节点
            let SubsuborgRsNavContext:any = {};
            let SubsuborgRsNavParams:any = {};
            let SubsuborgRsParams:any = {};
			await this.fillSubsuborgNodes(context, filter, list ,SubsuborgRsNavContext,SubsuborgRsNavParams,SubsuborgRsParams);
		}
	}

    /**
     * 填充 树视图节点[组织部门节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public fillSubormorgsectorNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
        return new Promise((resolve:any,reject:any) =>{
            let searchFilter: any = {};
            if (Object.is(filter.strNodeType, this.TREENODE_SUBSUBORG)) {
                Object.assign(searchFilter, { n_orgid_eq: filter.nodeid });
            }

            Object.assign(searchFilter, { total: false });
            Object.assign(searchFilter, { query: filter.srfnodefilter });
            let bFirst: boolean = true;
            let records: any[] = [];
            try {
                this.searchSubormorgsector(context, searchFilter, filter).then((records:any) =>{
                    if(records && records.length >0){
                        records.forEach((entity: any) => {
                        let treeNode: any = {};
                        // 整理context
                        let strId: string = entity.orgsectorid;
                        let strText: string = entity.shortname;
                        Object.assign(treeNode,{srfparentdename:'OrmOrgsector',srfparentkey:entity.orgsectorid});
                        let tempContext:any = JSON.parse(JSON.stringify(context));
                        Object.assign(tempContext,{srfparentdename:'OrmOrgsector',srfparentkey:entity.orgsectorid,ormorgsector:strId})
                        Object.assign(treeNode,{srfappctx:tempContext});
                        Object.assign(treeNode,{'ormorgsector':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'SubORMORGSECTOR';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { iconcls: 'copy' });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: true });
                        Object.assign(treeNode, { curData: entity });
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
     * @public
     * @param {any{}} context     
     * @param {*} searchFilter
     * @param {*} filter
     * @returns {any[]}
     * @memberof TestEnetityDatasService
     */
    @Errorlog
    public searchSubormorgsector(context:any={}, searchFilter: any, filter: any): Promise<any> {
        return new Promise((resolve:any,reject:any) =>{
            if(filter.viewparams){
                Object.assign(searchFilter,filter.viewparams);
            }
            if(!searchFilter.page){
                Object.assign(searchFilter,{page:0});
            }
            if(!searchFilter.size){
                Object.assign(searchFilter,{size:1000});
            }
            if(context && context.srfparentdename){
                Object.assign(searchFilter,{srfparentdename:JSON.parse(JSON.stringify(context)).srfparentdename});
            }
            if(context && context.srfparentkey){
                Object.assign(searchFilter,{srfparentkey:JSON.parse(JSON.stringify(context)).srfparentkey});
            }
            Object.assign(searchFilter,{sort: 'ordervalue,asc'})
            const _appEntityService: any = this.ormorgsectorService;
            let list: any[] = [];
            if (_appEntityService['FetchSubZZBM'] && _appEntityService['FetchSubZZBM'] instanceof Function) {
                const response: Promise<any> = _appEntityService['FetchSubZZBM'](context, searchFilter, false);
                response.then((response: any) => {
                    if (!response.status || response.status !== 200) {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchSubZZBM数据集异常!');
                    }
                    const data: any = response.data;
                    if (Object.keys(data).length > 0) {
                        list = JSON.parse(JSON.stringify(data));
                        resolve(list);
                    } else {
                        resolve([]);
                    }
                }).catch((response: any) => {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchSubZZBM数据集异常!');
                });
            }
        })
    }

    /**
     * 填充 树视图节点[组织部门节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public async fillSubormorgsectorNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
		} else {
		}
	}

    /**
     * 填充 树视图节点[根节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public fillRootNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
        return new Promise((resolve:any,reject:any) =>{
            let treeNode: any = {};
            Object.assign(treeNode, { text: 'entities.ormorg.ormorgtree2_treeview.nodes.root' });
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
            Object.assign(treeNode, { nodeid: treeNode.srfkey });
            Object.assign(treeNode, { nodeid2: filter.strRealNodeId });
            list.push(treeNode);
            resolve(list);
        });
	}

    /**
     * 填充 树视图节点[根节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof ORMORGTree2Service
     */
    @Errorlog
    public async fillRootNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充一级组织节点
            let OrmorgRsNavContext:any = {};
            let OrmorgRsNavParams:any = {};
            let OrmorgRsParams:any = {};
			await this.fillOrmorgNodes(context, filter, list ,OrmorgRsNavContext,OrmorgRsNavParams,OrmorgRsParams);
		} else {
			// 填充一级组织节点
            let OrmorgRsNavContext:any = {};
            let OrmorgRsNavParams:any = {};
            let OrmorgRsParams:any = {};
			await this.fillOrmorgNodes(context, filter, list ,OrmorgRsNavContext,OrmorgRsNavParams,OrmorgRsParams);
		}
	}


    /**
     * 处理代码表返回数据(树状结构)
     * 
     * @param result 返回数组
     * @param context 应用上下文
     * @param callBack 回调
     * @memberof ORMORGTree2Service
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
     * @memberof ORMORGTree2Service
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
     * @memberof ORMORGTree2Service
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

    /**
     * 处理节点关系导航上下文
     *
     * @param context 应用上下文
     * @param filter 参数 
     * @param resNavContext 节点关系导航上下文
     *
     * @memberof ORMORGTree2Service
     */
    public handleResNavContext(context:any,filter:any,resNavContext:any){
        if(resNavContext && Object.keys(resNavContext).length > 0){
            let tempContextData:any = JSON.parse(JSON.stringify(context));
            let tempViewParams:any = {};
            if(filter && filter.viewparams){
                tempViewParams = filter.viewparams;
            }
            Object.keys(resNavContext).forEach((item:any) =>{
                let curDataObj:any = resNavContext[item];
                this.handleCustomDataLogic(context,tempViewParams,curDataObj,tempContextData,item);
            })
            return tempContextData;
        }else{
            return context;
        }
    }

    /**
     * 处理关系导航参数
     *
     * @param context 应用上下文
     * @param filter 参数 
     * @param resNavParams 节点关系导航参数
     * @param resParams 节点关系参数
     *
     * @memberof ORMORGTree2Service
     */
	public handleResNavParams(context:any,filter:any,resNavParams:any,resParams:any){
        if((resNavParams && Object.keys(resNavParams).length >0) || (resParams && Object.keys(resParams).length >0)){
            let tempViewParamData:any = {};
            let tempViewParams:any = {};
            if(filter && filter.viewparams){
                tempViewParams = filter.viewparams;
                tempViewParamData = JSON.parse(JSON.stringify(filter.viewparams));
            }
            if( Object.keys(resNavParams).length > 0){
                Object.keys(resNavParams).forEach((item:any) =>{
                    let curDataObj:any = resNavParams[item];
                    this.handleCustomDataLogic(context,tempViewParams,curDataObj,tempViewParamData,item);
                })
            }
            if( Object.keys(resParams).length > 0){
                Object.keys(resParams).forEach((item:any) =>{
                    let curDataObj:any = resParams[item];
                    tempViewParamData[item.toLowerCase()] = curDataObj.value;
                })
            }
            Object.assign(filter,{viewparams:tempViewParamData});
            return filter;
        }else{
            return filter;
        }
    }
    
    /**
     * 处理自定义节点关系导航数据
     * 
     * @param context 应用上下文
     * @param viewparams 参数 
     * @param curNavData 节点关系导航参数对象
     * @param tempData 返回数据
     * @param item 节点关系导航参数键值
     *
     * @memberof ORMORGTree2Service
     */
	public handleCustomDataLogic(context:any,viewparams:any,curNavData:any,tempData:any,item:string){
		// 直接值直接赋值
		if(curNavData.isRawValue){
			if(Object.is(curNavData.value,"null") || Object.is(curNavData.value,"")){
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: null,
                    writable : true,
                    enumerable : true,
                    configurable : true
                });
            }else{
                Object.defineProperty(tempData, item.toLowerCase(), {
                    value: curNavData.value,
                    writable : true,
                    enumerable : true,
                    configurable : true
                });
            }
		}else{
			// 先从导航上下文取数，没有再从导航参数（URL）取数，如果导航上下文和导航参数都没有则为null
			if(context[(curNavData.value).toLowerCase()]){
				Object.defineProperty(tempData, item.toLowerCase(), {
					value: context[(curNavData.value).toLowerCase()],
					writable : true,
					enumerable : true,
					configurable : true
				});
			}else{
				if(viewparams[(curNavData.value).toLowerCase()]){
					Object.defineProperty(tempData, item.toLowerCase(), {
						value: viewparams[(curNavData.value).toLowerCase()],
						writable : true,
						enumerable : true,
						configurable : true
					});
				}else{
					Object.defineProperty(tempData, item.toLowerCase(), {
						value: null,
						writable : true,
						enumerable : true,
						configurable : true
					});
				}
			}
		}
	}

}