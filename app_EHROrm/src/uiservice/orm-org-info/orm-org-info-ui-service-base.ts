import { Environment } from '@/environments/environment';
import { UIActionTool,Util } from '@/utils';
import UIService from '../ui-service';
import { Subject } from 'rxjs';
import OrmOrgInfoService from '@/service/orm-org-info/orm-org-info-service';

/**
 * 组织信息UI服务对象基类
 *
 * @export
 * @class OrmOrgInfoUIServiceBase
 */
export default class OrmOrgInfoUIServiceBase extends UIService {

    /**
     * 是否支持工作流
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */
    public isEnableWorkflow:boolean = false;

    /**
     * 当前UI服务对应的数据服务对象
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */
    public dataService:OrmOrgInfoService = new OrmOrgInfoService();

    /**
     * 所有关联视图
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */ 
    public allViewMap: Map<string, Object> = new Map();

    /**
     * 状态值
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */ 
    public stateValue: number = 0;

    /**
     * 状态属性
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */ 
    public stateField: string = "";

    /**
     * 主状态属性集合
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */  
    public mainStateFields:Array<any> = [];

    /**
     * 主状态集合Map
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */  
    public allDeMainStateMap:Map<string,string> = new Map();

    /**
     * Creates an instance of  OrmOrgInfoUIServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgInfoUIServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.initViewMap();
        this.initDeMainStateMap();
    }

    /**
     * 初始化视图Map
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */  
    public initViewMap(){
        this.allViewMap.set(':',{viewname:'subsubsuborggridview',srfappde:'ormorginfos'});
        this.allViewMap.set('MDATAVIEW:',{viewname:'gridview',srfappde:'ormorginfos'});
        this.allViewMap.set('REDIRECTVIEW:',{viewname:'redirectview',srfappde:'ormorginfos'});
        this.allViewMap.set(':',{viewname:'subsuborggridview',srfappde:'ormorginfos'});
        this.allViewMap.set('PICKUPVIEW:',{viewname:'pickupview',srfappde:'ormorginfos'});
        this.allViewMap.set(':',{viewname:'orgtreegridview',srfappde:'ormorginfos'});
        this.allViewMap.set(':',{viewname:'pickupgridview',srfappde:'ormorginfos'});
        this.allViewMap.set(':',{viewname:'editview2',srfappde:'ormorginfos'});
        this.allViewMap.set('EDITVIEW:',{viewname:'editview',srfappde:'ormorginfos'});
        this.allViewMap.set(':',{viewname:'suborggridview',srfappde:'ormorginfos'});
        this.allViewMap.set('MPICKUPVIEW:',{viewname:'mpickupview',srfappde:'ormorginfos'});
        this.allViewMap.set(':',{viewname:'orgtreeexpview',srfappde:'ormorginfos'});
    }

    /**
     * 初始化主状态集合
     * 
     * @memberof  OrmOrgInfoUIServiceBase
     */  
    public initDeMainStateMap(){
    }

    /**
     * 新建部门
     *
     * @param {any[]} args 当前数据
     * @param {any} context 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {*} [srfParentDeName] 父实体名称
     * @returns {Promise<any>}
     */
    public async OrmOrgInfo_NewRecordDepLower(args: any[], context:any = {} ,params: any={}, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
    
        let data: any = {};
        let parentContext:any = {};
        let parentViewParam:any = {};
        const _this: any = actionContext;
        const _args: any[] = Util.deepCopy(args);
        const actionTarget: string | null = 'NONE';
        if(_this.context){
            parentContext = _this.context;
        }
        if(_this.viewparams){
            parentViewParam = _this.viewparams;
        }
        context = UIActionTool.handleContextParam(actionTarget,_args,parentContext,parentViewParam,context);
        data = UIActionTool.handleActionParam(actionTarget,_args,parentContext,parentViewParam,params);
        context = Object.assign({},actionContext.context,context);
        let parentObj:any = {srfparentdename:srfParentDeName?srfParentDeName:null,srfparentkey:srfParentDeName?context[srfParentDeName.toLowerCase()]:null};
        Object.assign(data,parentObj);
        Object.assign(context,parentObj);
        let deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormerporgs', parameterName: 'ormerporg' },
            { pathName: 'suborgsectorgridview', parameterName: 'suborgsectorgridview' },
        ];
            actionContext.closeView(null);
        const openIndexViewTab = (data: any) => {
            const routePath = actionContext.$viewTool.buildUpRoutePath(actionContext.$route, context, deResParameters, parameters, _args, data);
            actionContext.$router.push(routePath);
            if (xData && xData.refresh && xData.refresh instanceof Function) {
                xData.refresh(args);
            }
            return null;
        }
        openIndexViewTab(data);
    }

    /**
     * 新建项目部
     *
     * @param {any[]} args 当前数据
     * @param {any} context 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {*} [srfParentDeName] 父实体名称
     * @returns {Promise<any>}
     */
    public async OrmOrgInfo_NewRecordPro(args: any[], context:any = {} ,params: any={}, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
    
        let data: any = {};
        let parentContext:any = {};
        let parentViewParam:any = {};
        const _this: any = actionContext;
        const _args: any[] = Util.deepCopy(args);
        const actionTarget: string | null = 'NONE';
        if(_this.context){
            parentContext = _this.context;
        }
        if(_this.viewparams){
            parentViewParam = _this.viewparams;
        }
        context = UIActionTool.handleContextParam(actionTarget,_args,parentContext,parentViewParam,context);
        data = UIActionTool.handleActionParam(actionTarget,_args,parentContext,parentViewParam,params);
        context = Object.assign({},actionContext.context,context);
        let parentObj:any = {srfparentdename:srfParentDeName?srfParentDeName:null,srfparentkey:srfParentDeName?context[srfParentDeName.toLowerCase()]:null};
        Object.assign(data,parentObj);
        Object.assign(context,parentObj);
        let deResParameters: any[] = [];
        if(context.ormorg && true){
            deResParameters = [
            { pathName: 'ormorgs', parameterName: 'ormorg' },
            ]
        }
        const parameters: any[] = [
            { pathName: 'ormorgsectors', parameterName: 'ormorgsector' },
            { pathName: 'xmbbzgleditview', parameterName: 'xmbbzgleditview' },
        ];
        const openIndexViewTab = (data: any) => {
            const routePath = actionContext.$viewTool.buildUpRoutePath(actionContext.$route, context, deResParameters, parameters, _args, data);
            actionContext.$router.push(routePath);
            if (xData && xData.refresh && xData.refresh instanceof Function) {
                xData.refresh(args);
            }
            return null;
        }
        openIndexViewTab(data);
    }

    /**
     * 新建组织
     *
     * @param {any[]} args 当前数据
     * @param {any} context 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {*} [srfParentDeName] 父实体名称
     * @returns {Promise<any>}
     */
    public async OrmOrgInfo_NewRecord(args: any[], context:any = {} ,params: any={}, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
    
        let data: any = {};
        let parentContext:any = {};
        let parentViewParam:any = {};
        const _this: any = actionContext;
        const _args: any[] = Util.deepCopy(args);
        const actionTarget: string | null = 'NONE';
        if(_this.context){
            parentContext = _this.context;
        }
        if(_this.viewparams){
            parentViewParam = _this.viewparams;
        }
        context = UIActionTool.handleContextParam(actionTarget,_args,parentContext,parentViewParam,context);
        data = UIActionTool.handleActionParam(actionTarget,_args,parentContext,parentViewParam,params);
        context = Object.assign({},actionContext.context,context);
        let parentObj:any = {srfparentdename:srfParentDeName?srfParentDeName:null,srfparentkey:srfParentDeName?context[srfParentDeName.toLowerCase()]:null};
        Object.assign(data,parentObj);
        Object.assign(context,parentObj);
        let deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormerporgs', parameterName: 'ormerporg' },
            { pathName: 'gridview', parameterName: 'gridview' },
        ];
            actionContext.closeView(null);
        const openIndexViewTab = (data: any) => {
            const routePath = actionContext.$viewTool.buildUpRoutePath(actionContext.$route, context, deResParameters, parameters, _args, data);
            actionContext.$router.push(routePath);
            if (xData && xData.refresh && xData.refresh instanceof Function) {
                xData.refresh(args);
            }
            return null;
        }
        openIndexViewTab(data);
    }

    /**
     * 新建部门
     *
     * @param {any[]} args 当前数据
     * @param {any} context 行为附加上下文
     * @param {*} [params] 附加参数
     * @param {*} [$event] 事件源
     * @param {*} [xData]  执行行为所需当前部件
     * @param {*} [actionContext]  执行行为上下文
     * @param {*} [srfParentDeName] 父实体名称
     * @returns {Promise<any>}
     */
    public async OrmOrgInfo_NewRecordDep(args: any[], context:any = {} ,params: any={}, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
    
        let data: any = {};
        let parentContext:any = {};
        let parentViewParam:any = {};
        const _this: any = actionContext;
        const _args: any[] = Util.deepCopy(args);
        const actionTarget: string | null = 'NONE';
        if(_this.context){
            parentContext = _this.context;
        }
        if(_this.viewparams){
            parentViewParam = _this.viewparams;
        }
        context = UIActionTool.handleContextParam(actionTarget,_args,parentContext,parentViewParam,context);
        data = UIActionTool.handleActionParam(actionTarget,_args,parentContext,parentViewParam,params);
        context = Object.assign({},actionContext.context,context);
        let parentObj:any = {srfparentdename:srfParentDeName?srfParentDeName:null,srfparentkey:srfParentDeName?context[srfParentDeName.toLowerCase()]:null};
        Object.assign(data,parentObj);
        Object.assign(context,parentObj);
        let deResParameters: any[] = [];
        const parameters: any[] = [
            { pathName: 'ormerporgs', parameterName: 'ormerporg' },
            { pathName: 'orgsectorgridview', parameterName: 'orgsectorgridview' },
        ];
            actionContext.closeView(null);
        const openIndexViewTab = (data: any) => {
            const routePath = actionContext.$viewTool.buildUpRoutePath(actionContext.$route, context, deResParameters, parameters, _args, data);
            actionContext.$router.push(routePath);
            if (xData && xData.refresh && xData.refresh instanceof Function) {
                xData.refresh(args);
            }
            return null;
        }
        openIndexViewTab(data);
    }


    /**
     * 获取指定数据的重定向页面
     * 
     * @param srfkey 数据主键
     * @param isEnableWorkflow  重定向视图是否需要处理流程中的数据
     * @memberof  OrmOrgInfoUIServiceBase
     */
    public async getRDAppView(srfkey:string,isEnableWorkflow:boolean){
        this.isEnableWorkflow = isEnableWorkflow;
        // 进行数据查询
        let result:any = await this.dataService.Get({ormorginfo:srfkey});
        const curData:any = result.data;
        //判断当前数据模式,默认为true，todo
        const iRealDEModel:boolean = true;

        let bDataInWF:boolean = false;
		let bWFMode:any = false;
		// 计算数据模式
		if (this.isEnableWorkflow) {
			bDataInWF = await this.dataService.testDataInWF({stateValue:this.stateValue,stateField:this.stateField},curData);
			if (bDataInWF) {
				bDataInWF = true;
				bWFMode = await this.dataService.testUserExistWorklist(null,curData);
			}
        }
        let strPDTViewParam:string = await this.getDESDDEViewPDTParam(curData, bDataInWF, bWFMode);
        //若不是当前数据模式，处理strPDTViewParam，todo

        //查找视图

        //返回视图
        return this.allViewMap.get(strPDTViewParam);
    }

    /**
	 * 获取实际的数据类型
     * 
     * @memberof  OrmOrgInfoUIServiceBase
	 */
	public getRealDEType(entity:any){

    }

    /**
     * 获取实体单数据实体视图预定义参数
     * 
     * @param curData 当前数据
     * @param bDataInWF 是否有数据在工作流中
     * @param bWFMode   是否工作流模式
     * @memberof  OrmOrgInfoUIServiceBase
     */
    public async getDESDDEViewPDTParam(curData:any, bDataInWF:boolean, bWFMode:boolean){
        let strPDTParam:string = '';
		if (bDataInWF) {
			// 判断数据是否在流程中
        }
        //多表单，todo
        const isEnableMultiForm:boolean = false;
        const multiFormDEField:string|null =null;

        if (isEnableMultiForm && multiFormDEField) {
			const objFormValue:string = curData[multiFormDEField];
			if(!Environment.isAppMode){
				return 'MOBEDITVIEW'+objFormValue;
			}
			return 'EDITVIEW'+objFormValue;
        }
		if(!Environment.isAppMode){
            if(this.getDEMainStateTag(curData)){
                return `MOBEDITVIEW:MSTAG:${ await this.getDEMainStateTag(curData)}`;
            }
			return 'MOBEDITVIEW:';
        }
        if(this.getDEMainStateTag(curData)){
            return `EDITVIEW:MSTAG:${ await this.getDEMainStateTag(curData)}`;
        }
		return 'EDITVIEW:';
    }

    /**
     * 获取数据对象的主状态标识
     * 
     * @param curData 当前数据
     * @memberof  OrmOrgInfoUIServiceBase
     */  
    public async getDEMainStateTag(curData:any){
        if(this.mainStateFields.length === 0) return null;

        this.mainStateFields.forEach((singleMainField:any) =>{
            if(!(singleMainField in curData)){
                console.error(`当前数据对象不包含属性singleMainField，可能会发生错误`);
            }
        })

        let strTag:String = "";
        for (let i = 0; i <= 1; i++) {
            let strTag:string = (curData[this.mainStateFields[0]])?(i == 0) ? curData[this.mainStateFields[0]] : "":"";
            if (this.mainStateFields.length >= 2) {
                for (let j = 0; j <= 1; j++) {
                    let strTag2:string = (curData[this.mainStateFields[1]])?`${strTag}__${(j == 0) ? curData[this.mainStateFields[1]] : ""}`:strTag;
                    if (this.mainStateFields.length >= 3) {
                        for (let k = 0; k <= 1; k++) {
                            let strTag3:string = (curData[this.mainStateFields[2]])?`${strTag2}__${(k == 0) ? curData[this.mainStateFields[2]] : ""}`:strTag2;
                            // 判断是否存在
                            return this.allDeMainStateMap.get(strTag3);
                        }
                    }else{
                        return this.allDeMainStateMap.get(strTag2);
                    }
                }
            }else{
                return this.allDeMainStateMap.get(strTag);
            }
        }
        return null;
    }

}