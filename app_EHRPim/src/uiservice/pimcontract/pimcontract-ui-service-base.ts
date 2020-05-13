import { Environment } from '@/environments/environment';
import { UIActionTool,Util } from '@/utils';
import UIService from '../ui-service';
import { Subject } from 'rxjs';
import PIMCONTRACTService from '@/service/pimcontract/pimcontract-service';

/**
 * 合同信息UI服务对象基类
 *
 * @export
 * @class PIMCONTRACTUIServiceBase
 */
export default class PIMCONTRACTUIServiceBase extends UIService {

    /**
     * 是否支持工作流
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */
    protected isEnableWorkflow:boolean = false;

    /**
     * 当前UI服务对应的数据服务对象
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */
    protected dataService:PIMCONTRACTService = new PIMCONTRACTService();

    /**
     * 所有关联视图
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */ 
    protected allViewMap: Map<string, Object> = new Map();

    /**
     * 状态值
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */ 
    protected stateValue: number = 0;

    /**
     * 状态属性
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */ 
    protected stateField: string = "";

    /**
     * 主状态属性集合
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */  
    protected mainStateFields:Array<any> = [];

    /**
     * 主状态集合Map
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */  
    protected allDeMainStateMap:Map<string,string> = new Map();

    /**
     * Creates an instance of  PIMCONTRACTUIServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PIMCONTRACTUIServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.initViewMap();
        this.initDeMainStateMap();
    }

    /**
     * 初始化视图Map
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */  
    public initViewMap(){
        this.allViewMap.set(':',{viewname:'stopremindgridview',srfappde:'pimcontracts'});
        this.allViewMap.set('MPICKUPVIEW:',{viewname:'mpickupview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'grcontracteditview',srfappde:'pimcontracts'});
        this.allViewMap.set('PICKUPVIEW:',{viewname:'pickupview',srfappde:'pimcontracts'});
        this.allViewMap.set('MDATAVIEW:',{viewname:'gridview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'wssgridview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'lwgridview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'grcontractgridview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'xygridview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'editview2',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'ldeditview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'signremindgridview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'lweditview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'treeexpview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'reneweditview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'ylweditview',srfappde:'pimcontracts'});
        this.allViewMap.set('REDIRECTVIEW:',{viewname:'redirectview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'pickupgridview',srfappde:'pimcontracts'});
        this.allViewMap.set('EDITVIEW:',{viewname:'editview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'ydtxgridview9',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'expiregridview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'stoptimeselecteditview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'xylweditview',srfappde:'pimcontracts'});
        this.allViewMap.set(':',{viewname:'ldgridview',srfappde:'pimcontracts'});
    }

    /**
     * 初始化主状态集合
     * 
     * @memberof  PIMCONTRACTUIServiceBase
     */  
    public initDeMainStateMap(){
    }

    /**
     * 续签
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
    public async PIMCONTRACT_Renew(args: any[], context:any = {} ,params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        actionContext.$Notice.error({ title: '错误', desc: '不支持单项数据' });
    }

    /**
     * 终止合同
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
    public async PIMCONTRACT_StopContract(args: any[], context:any = {} ,params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        let data: any = {};
        const _args: any[] = Util.deepCopy(args);
        const _this: any = actionContext;
        const actionTarget: string | null = 'SINGLEKEY';
        Object.assign(context, { pimcontract: '%pimcontract%' });
        Object.assign(params, { pimcontractid: '%pimcontract%' });
        Object.assign(params, { pimpersonname: '%pimpersonname%' });
        context = UIActionTool.handleContextParam(actionTarget,_args,context);
        data = UIActionTool.handleActionParam(actionTarget,_args,params);
        context = Object.assign({},actionContext.context,context);
        let parentObj:any = {srfparentdename:srfParentDeName?srfParentDeName:null,srfparentkey:srfParentDeName?context[srfParentDeName.toLowerCase()]:null};
        Object.assign(data,parentObj);
        Object.assign(context,parentObj);
        let deResParameters: any[] = [];
        if(context.pimperson && true){
            deResParameters = [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            ]
        }
        const parameters: any[] = [
            { pathName: 'pimcontracts', parameterName: 'pimcontract' },
            { pathName: 'stoptimeselecteditview', parameterName: 'stoptimeselecteditview' },
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
     * 新签
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
    public async PIMCONTRACT_Signnew(args: any[], context:any = {} ,params?: any, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
        actionContext.$Notice.error({ title: '错误', desc: '不支持单项数据' });
    }


    /**
     * 获取指定数据的重定向页面
     * 
     * @param srfkey 数据主键
     * @param isEnableWorkflow  重定向视图是否需要处理流程中的数据
     * @memberof  PIMCONTRACTUIServiceBase
     */
    public async getRDAppView(srfkey:string,isEnableWorkflow:boolean){
        this.isEnableWorkflow = isEnableWorkflow;
        // 进行数据查询
        let result:any = await this.dataService.Get({pimcontract:srfkey});
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
     * @memberof  PIMCONTRACTUIServiceBase
	 */
	protected getRealDEType(entity:any){

    }

    /**
     * 获取实体单数据实体视图预定义参数
     * 
     * @param curData 当前数据
     * @param bDataInWF 是否有数据在工作流中
     * @param bWFMode   是否工作流模式
     * @memberof  PIMCONTRACTUIServiceBase
     */
    protected async getDESDDEViewPDTParam(curData:any, bDataInWF:boolean, bWFMode:boolean){
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
     * @memberof  PIMCONTRACTUIServiceBase
     */  
    protected async getDEMainStateTag(curData:any){
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