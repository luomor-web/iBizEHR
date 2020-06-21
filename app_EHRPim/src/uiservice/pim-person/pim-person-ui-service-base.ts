import { Environment } from '@/environments/environment';
import { UIActionTool,Util } from '@/utils';
import UIService from '../ui-service';
import { Subject } from 'rxjs';
import PimPersonService from '@/service/pim-person/pim-person-service';

/**
 * 人员信息UI服务对象基类
 *
 * @export
 * @class PimPersonUIServiceBase
 */
export default class PimPersonUIServiceBase extends UIService {

    /**
     * 是否支持工作流
     * 
     * @memberof  PimPersonUIServiceBase
     */
    public isEnableWorkflow:boolean = false;

    /**
     * 当前UI服务对应的数据服务对象
     * 
     * @memberof  PimPersonUIServiceBase
     */
    public dataService:PimPersonService = new PimPersonService();

    /**
     * 所有关联视图
     * 
     * @memberof  PimPersonUIServiceBase
     */ 
    public allViewMap: Map<string, Object> = new Map();

    /**
     * 状态值
     * 
     * @memberof  PimPersonUIServiceBase
     */ 
    public stateValue: number = 0;

    /**
     * 状态属性
     * 
     * @memberof  PimPersonUIServiceBase
     */ 
    public stateField: string = "";

    /**
     * 主状态属性集合
     * 
     * @memberof  PimPersonUIServiceBase
     */  
    public mainStateFields:Array<any> = [];

    /**
     * 主状态集合Map
     * 
     * @memberof  PimPersonUIServiceBase
     */  
    public allDeMainStateMap:Map<string,string> = new Map();

    /**
     * Creates an instance of  PimPersonUIServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  PimPersonUIServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.initViewMap();
        this.initDeMainStateMap();
    }

    /**
     * 初始化视图Map
     * 
     * @memberof  PimPersonUIServiceBase
     */  
    public initViewMap(){
        this.allViewMap.set(':',{viewname:'ryinfogridview',srfappde:'pimpeople'});
        this.allViewMap.set('MDATAVIEW:',{viewname:'gridview',srfappde:'pimpeople'});
        this.allViewMap.set('MPICKUPVIEW:',{viewname:'mpickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'neweditview2',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'yxzfppickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'personinfoeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'curleaderpickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'grxscgeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'bylygpickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'curorgpimpersonpickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'editview2',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'xscgeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'personinfotreeexpview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'syjxeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'gzdqgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'gzryhmcgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'txyggridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'kqjrypickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'yxzfppickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'curorgpimpersonpickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'curorgpersonpickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'grgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'zdeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'curjhrypickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'jxqyggridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'zddeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'grzhzceditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'greditview2',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'txrypickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'falygmpickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'curjhrypickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'hmdgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'kxzxygpickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set('EDITVIEW:',{viewname:'editview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'xzkqrypickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'quickeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'jxqpickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'xzkqrympickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'pickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'curleaderpickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'curorgpersonpickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'grzzeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'proinfoeditview2',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'zhzceditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'ltxyggridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'syqyggridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'kqjrypickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'txqreditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'ryinfoeditview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'jxspickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'kxzxygpickupview',srfappde:'pimpeople'});
        this.allViewMap.set('PICKUPVIEW:',{viewname:'pickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'txrypickupview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'bylygpickupgridview',srfappde:'pimpeople'});
        this.allViewMap.set(':',{viewname:'lzyghmcgridview',srfappde:'pimpeople'});
    }

    /**
     * 初始化主状态集合
     * 
     * @memberof  PimPersonUIServiceBase
     */  
    public initDeMainStateMap(){
    }

    /**
     * 新建
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
    public async PimPerson_QuickCreatePerson(args: any[], context:any = {} ,params: any={}, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
    
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
            { pathName: 'pimpeople', parameterName: 'pimperson' },
        ];
            const openPopupModal = (view: any, data: any) => {
                let container: Subject<any> = actionContext.$appmodal.openModal(view, context, data);
                container.subscribe((result: any) => {
                    if (!result || !Object.is(result.ret, 'OK')) {
                        return;
                    }
                    const _this: any = actionContext;
                    if (xData && xData.refresh && xData.refresh instanceof Function) {
                        xData.refresh(args);
                    }
                    if (this.PimPerson_OpenAllInfoView && this.PimPerson_OpenAllInfoView instanceof Function) {
                        this.PimPerson_OpenAllInfoView(result.datas,context, params, $event, xData,actionContext);
                    }
                    if(window.opener){
                        window.opener.postMessage({status:'OK',identification:'WF'},Environment.uniteAddress);
                        window.close();
                    }
                    return result.datas;
                });
            }
            const view: any = {
                viewname: 'pimpersonquick-edit-view', 
                height: 500, 
                width: 450,  
                title: actionContext.$t('entities.pimperson.views.quickeditview.title'),
            };
            openPopupModal(view, data);
    }

    /**
     * 编辑
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
    public async PimPerson_OpenEditView(args: any[], context:any = {} ,params: any={}, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
    
        let data: any = {};
        let parentContext:any = {};
        let parentViewParam:any = {};
        const _this: any = actionContext;
        const _args: any[] = Util.deepCopy(args);
        const actionTarget: string | null = 'SINGLEKEY';
        Object.assign(context, { pimperson: '%pimperson%' });
        Object.assign(params, { pimpersonid: '%pimperson%' });
        Object.assign(params, { pimpersonname: '%pimpersonname%' });
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
            { pathName: 'pimpeople', parameterName: 'pimperson' },
        ];
            const openDrawer = (view: any, data: any) => {
                let container: Subject<any> = actionContext.$appdrawer.openDrawer(view, context,data);
                container.subscribe((result: any) => {
                    if (!result || !Object.is(result.ret, 'OK')) {
                        return;
                    }
                    const _this: any = actionContext;
                    if (xData && xData.refresh && xData.refresh instanceof Function) {
                        xData.refresh(args);
                    }
                    if(window.opener){
                        window.opener.postMessage({status:'OK',identification:'WF'},Environment.uniteAddress);
                        window.close();
                    }
                    return result.datas;
                });
            }
            const view: any = {
                viewname: 'pimpersonperson-info-edit-view', 
                height: 0, 
                width: 1366,  
                title: actionContext.$t('entities.pimperson.views.personinfoeditview.title'),
                placement: 'DRAWER_RIGHT',
            };
            openDrawer(view, data);
    }

    /**
     * 编辑
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
    public async PimPerson_OpenAllInfoView(args: any[], context:any = {} ,params: any={}, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
    
        let data: any = {};
        let parentContext:any = {};
        let parentViewParam:any = {};
        const _this: any = actionContext;
        const _args: any[] = Util.deepCopy(args);
        const actionTarget: string | null = 'SINGLEKEY';
        Object.assign(context, { pimperson: '%pimperson%' });
        Object.assign(params, { pimpersonid: '%pimperson%' });
        Object.assign(params, { pimpersonname: '%pimpersonname%' });
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
            { pathName: 'pimpeople', parameterName: 'pimperson' },
        ];
            const openDrawer = (view: any, data: any) => {
                let container: Subject<any> = actionContext.$appdrawer.openDrawer(view, context,data);
                container.subscribe((result: any) => {
                    if (!result || !Object.is(result.ret, 'OK')) {
                        return;
                    }
                    const _this: any = actionContext;
                    if(window.opener){
                        window.opener.postMessage({status:'OK',identification:'WF'},Environment.uniteAddress);
                        window.close();
                    }
                    return result.datas;
                });
            }
            const view: any = {
                viewname: 'pimpersonedit-view2', 
                height: 0, 
                width: 0,  
                title: actionContext.$t('entities.pimperson.views.editview2.title'),
                placement: 'DRAWER_TOP',
            };
            openDrawer(view, data);
    }


    /**
     * 获取指定数据的重定向页面
     * 
     * @param srfkey 数据主键
     * @param isEnableWorkflow  重定向视图是否需要处理流程中的数据
     * @memberof  PimPersonUIServiceBase
     */
    public async getRDAppView(srfkey:string,isEnableWorkflow:boolean){
        this.isEnableWorkflow = isEnableWorkflow;
        // 进行数据查询
        let result:any = await this.dataService.Get({pimperson:srfkey});
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
     * @memberof  PimPersonUIServiceBase
	 */
	public getRealDEType(entity:any){

    }

    /**
     * 获取实体单数据实体视图预定义参数
     * 
     * @param curData 当前数据
     * @param bDataInWF 是否有数据在工作流中
     * @param bWFMode   是否工作流模式
     * @memberof  PimPersonUIServiceBase
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
     * @memberof  PimPersonUIServiceBase
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