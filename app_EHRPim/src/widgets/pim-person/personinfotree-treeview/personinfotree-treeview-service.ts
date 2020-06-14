import { Http,Util,Errorlog } from '@/utils';
import ControlService from '@/widgets/control-service';
import PimPersonService from '@/service/pim-person/pim-person-service';
import PERSONINFOTREEModel from './personinfotree-treeview-model';
import CodeListService from '@service/app/codelist-service';
import i18n from '@/locale';
import OrmOrgService from '@service/orm-org/orm-org-service';
import OrmOrgsectorService from '@service/orm-orgsector/orm-orgsector-service';


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
     * @type {PimPersonService}
     * @memberof PERSONINFOTREEService
     */
    public appEntityService: PimPersonService = new PimPersonService({ $store: this.getStore() });

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
     * @type {OrmOrgService}
     * @memberof PERSONINFOTREEService
     */
    public ormorgService: OrmOrgService = new OrmOrgService({ $store: this.getStore() });

    /**
     * 部门管理服务对象
     *
     * @type {OrmOrgsectorService}
     * @memberof PERSONINFOTREEService
     */
    public ormorgsectorService: OrmOrgsectorService = new OrmOrgsectorService({ $store: this.getStore() });

    /**
     * 节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
    public TREENODE_SEPARATOR: string = ';';

    /**
     * 根组织节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	public TREENODE_ORMORGINFO: string = 'ORMORGINFO';

    /**
     * 子组织节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	public TREENODE_SUBORMORGINFO: string = 'SUBORMORGINFO';

    /**
     * 子子组织节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	public TREENODE_SUBSUBORMORGINFO: string = 'SubSubORMORGINFO';

    /**
     * 子部门节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	public TREENODE_ORMORGSECTOR: string = 'ORMORGSECTOR';

    /**
     * 默认根节点节点分隔符号
     *
     * @public
     * @type {string}
     * @memberof PERSONINFOTREEService
     */
	public TREENODE_ROOT: string = 'ROOT';

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
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public fillOrmorginfoNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
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
                        Object.assign(treeNode,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid});
                        let tempContext:any = JSON.parse(JSON.stringify(context));
                        Object.assign(tempContext,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid,ormorg:strId})
                        Object.assign(treeNode,{srfappctx:tempContext});
                        Object.assign(treeNode,{'ormorg':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'ORMORGINFO';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: true });
                        Object.assign(treeNode, { leaf: false });
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
    public searchOrmorginfo(context:any={}, searchFilter: any, filter: any): Promise<any> {
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
            const _appEntityService: any = this.ormorgService;
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
     * 填充 树视图节点[根组织节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public async fillOrmorginfoNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充子部门节点
            let OrmorgsectorRsNavContext:any = {};
            let OrmorgsectorRsNavParams:any = {};
            let OrmorgsectorRsParams:any = {};
			await this.fillOrmorgsectorNodes(context, filter, list ,OrmorgsectorRsNavContext,OrmorgsectorRsNavParams,OrmorgsectorRsParams);
			// 填充子组织节点
            let SubormorginfoRsNavContext:any = {};
            let SubormorginfoRsNavParams:any = {};
            let SubormorginfoRsParams:any = {};
			await this.fillSubormorginfoNodes(context, filter, list ,SubormorginfoRsNavContext,SubormorginfoRsNavParams,SubormorginfoRsParams);
		} else {
			// 填充子部门节点
            let OrmorgsectorRsNavContext:any = {};
            let OrmorgsectorRsNavParams:any = {};
            let OrmorgsectorRsParams:any = {};
			await this.fillOrmorgsectorNodes(context, filter, list ,OrmorgsectorRsNavContext,OrmorgsectorRsNavParams,OrmorgsectorRsParams);
			// 填充子组织节点
            let SubormorginfoRsNavContext:any = {};
            let SubormorginfoRsNavParams:any = {};
            let SubormorginfoRsParams:any = {};
			await this.fillSubormorginfoNodes(context, filter, list ,SubormorginfoRsNavContext,SubormorginfoRsNavParams,SubormorginfoRsParams);
		}
	}

    /**
     * 填充 树视图节点[子组织节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public fillSubormorginfoNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
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
                        Object.assign(treeNode,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid});
                        let tempContext:any = JSON.parse(JSON.stringify(context));
                        Object.assign(tempContext,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid,ormorg:strId})
                        Object.assign(treeNode,{srfappctx:tempContext});
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
                        Object.assign(treeNode, { curData: entity });
                        Object.assign(treeNode, {navigateParams: {n_zgcode_eq:"10",nodeid:"%NODEID%"} });
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
    public searchSubormorginfo(context:any={}, searchFilter: any, filter: any): Promise<any> {
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
            const _appEntityService: any = this.ormorgService;
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
     * 填充 树视图节点[子组织节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public async fillSubormorginfoNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充子部门节点
            let OrmorgsectorRsNavContext:any = {};
            let OrmorgsectorRsNavParams:any = {};
            let OrmorgsectorRsParams:any = {};
			await this.fillOrmorgsectorNodes(context, filter, list ,OrmorgsectorRsNavContext,OrmorgsectorRsNavParams,OrmorgsectorRsParams);
			// 填充子子组织节点
            let SubsubormorginfoRsNavContext:any = {};
            let SubsubormorginfoRsNavParams:any = {};
            let SubsubormorginfoRsParams:any = {};
			await this.fillSubsubormorginfoNodes(context, filter, list ,SubsubormorginfoRsNavContext,SubsubormorginfoRsNavParams,SubsubormorginfoRsParams);
		} else {
			// 填充子部门节点
            let OrmorgsectorRsNavContext:any = {};
            let OrmorgsectorRsNavParams:any = {};
            let OrmorgsectorRsParams:any = {};
			await this.fillOrmorgsectorNodes(context, filter, list ,OrmorgsectorRsNavContext,OrmorgsectorRsNavParams,OrmorgsectorRsParams);
			// 填充子子组织节点
            let SubsubormorginfoRsNavContext:any = {};
            let SubsubormorginfoRsNavParams:any = {};
            let SubsubormorginfoRsParams:any = {};
			await this.fillSubsubormorginfoNodes(context, filter, list ,SubsubormorginfoRsNavContext,SubsubormorginfoRsNavParams,SubsubormorginfoRsParams);
		}
	}

    /**
     * 填充 树视图节点[子子组织节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public fillSubsubormorginfoNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
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
                        Object.assign(treeNode,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid});
                        let tempContext:any = JSON.parse(JSON.stringify(context));
                        Object.assign(tempContext,{srfparentdename:'OrmOrg',srfparentkey:entity.orgid,ormorg:strId})
                        Object.assign(treeNode,{srfappctx:tempContext});
                        Object.assign(treeNode,{'ormorg':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'SubSubORMORGINFO';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: false });
                        Object.assign(treeNode, { curData: entity });
                        Object.assign(treeNode, {navigateParams: {n_zgcode_eq:"10",nodeid:"%NODEID%"} });
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
    public searchSubsubormorginfo(context:any={}, searchFilter: any, filter: any): Promise<any> {
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
            const _appEntityService: any = this.ormorgService;
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
     * 填充 树视图节点[子子组织节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public async fillSubsubormorginfoNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充子部门节点
            let OrmorgsectorRsNavContext:any = {};
            let OrmorgsectorRsNavParams:any = {};
            let OrmorgsectorRsParams:any = {};
			await this.fillOrmorgsectorNodes(context, filter, list ,OrmorgsectorRsNavContext,OrmorgsectorRsNavParams,OrmorgsectorRsParams);
		} else {
			// 填充子部门节点
            let OrmorgsectorRsNavContext:any = {};
            let OrmorgsectorRsNavParams:any = {};
            let OrmorgsectorRsParams:any = {};
			await this.fillOrmorgsectorNodes(context, filter, list ,OrmorgsectorRsNavContext,OrmorgsectorRsNavParams,OrmorgsectorRsParams);
		}
	}

    /**
     * 填充 树视图节点[子部门节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public fillOrmorgsectorNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
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
                        Object.assign(treeNode,{srfparentdename:'OrmOrgsector',srfparentkey:entity.orgsectorid});
                        let tempContext:any = JSON.parse(JSON.stringify(context));
                        Object.assign(tempContext,{srfparentdename:'OrmOrgsector',srfparentkey:entity.orgsectorid,ormorgsector:strId})
                        Object.assign(treeNode,{srfappctx:tempContext});
                        Object.assign(treeNode,{'ormorgsector':strId});
                        Object.assign(treeNode, { srfkey: strId });
                        Object.assign(treeNode, { text: strText, srfmajortext: strText });
                        let strNodeId: string = 'ORMORGSECTOR';
                        strNodeId += this.TREENODE_SEPARATOR;
                        strNodeId += strId;
                        Object.assign(treeNode, { id: strNodeId });
                        Object.assign(treeNode, { expanded: filter.isautoexpand });
                        Object.assign(treeNode, { leaf: true });
                        Object.assign(treeNode, { curData: entity });
                        Object.assign(treeNode, {navigateParams: {n_zgcode_eq:"10",nodeid:"%NODEID%"} });
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
    public searchOrmorgsector(context:any={}, searchFilter: any, filter: any): Promise<any> {
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
            if (_appEntityService['FetchPimpersonInfoOrgsector'] && _appEntityService['FetchPimpersonInfoOrgsector'] instanceof Function) {
                const response: Promise<any> = _appEntityService['FetchPimpersonInfoOrgsector'](context, searchFilter, false);
                response.then((response: any) => {
                    if (!response.status || response.status !== 200) {
                        resolve([]);
                        console.log(JSON.stringify(context));
                        console.error('查询FetchPimpersonInfoOrgsector数据集异常!');
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
                        console.error('查询FetchPimpersonInfoOrgsector数据集异常!');
                });
            }
        })
    }

    /**
     * 填充 树视图节点[子部门节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public async fillOrmorgsectorNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
		} else {
		}
	}

    /**
     * 填充 树视图节点[默认根节点]
     *
     * @public
     * @param {any{}} context     
     * @param {*} filter
     * @param {any[]} list
     * @param {*} rsNavContext   
     * @param {*} rsNavParams
     * @param {*} rsParams
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public fillRootNodes(context:any={},filter: any, list: any[],rsNavContext?:any,rsNavParams?:any,rsParams?:any): Promise<any> {
        context = this.handleResNavContext(context,filter,rsNavContext);
        filter = this.handleResNavParams(context,filter,rsNavParams,rsParams);
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
            Object.assign(treeNode, { nodeid: treeNode.srfkey });
            Object.assign(treeNode, { nodeid2: filter.strRealNodeId });
            list.push(treeNode);
            resolve(list);
        });
	}

    /**
     * 填充 树视图节点[默认根节点]子节点
     *
     * @public
     * @param {any{}} context         
     * @param {*} filter
     * @param {any[]} list
     * @returns {Promise<any>}
     * @memberof PERSONINFOTREEService
     */
    @Errorlog
    public async fillRootNodeChilds(context:any={}, filter: any, list: any[]): Promise<any> {
		if (filter.srfnodefilter && !Object.is(filter.srfnodefilter,"")) {
			// 填充根组织节点
            let OrmorginfoRsNavContext:any = {};
            let OrmorginfoRsNavParams:any = {};
            let OrmorginfoRsParams:any = {};
			await this.fillOrmorginfoNodes(context, filter, list ,OrmorginfoRsNavContext,OrmorginfoRsNavParams,OrmorginfoRsParams);
		} else {
			// 填充根组织节点
            let OrmorginfoRsNavContext:any = {};
            let OrmorginfoRsNavParams:any = {};
            let OrmorginfoRsParams:any = {};
			await this.fillOrmorginfoNodes(context, filter, list ,OrmorginfoRsNavContext,OrmorginfoRsNavParams,OrmorginfoRsParams);
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

    /**
     * 处理节点关系导航上下文
     *
     * @param context 应用上下文
     * @param filter 参数 
     * @param resNavContext 节点关系导航上下文
     *
     * @memberof PERSONINFOTREEService
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
     * @memberof PERSONINFOTREEService
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
     * @memberof PERSONINFOTREEService
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