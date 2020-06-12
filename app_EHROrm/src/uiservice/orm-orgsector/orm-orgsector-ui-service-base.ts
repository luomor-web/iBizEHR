import { Environment } from '@/environments/environment';
import { UIActionTool,Util } from '@/utils';
import UIService from '../ui-service';
import { Subject } from 'rxjs';
import OrmOrgsectorService from '@/service/orm-orgsector/orm-orgsector-service';

/**
 * 部门管理UI服务对象基类
 *
 * @export
 * @class OrmOrgsectorUIServiceBase
 */
export default class OrmOrgsectorUIServiceBase extends UIService {

    /**
     * 是否支持工作流
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */
    public isEnableWorkflow:boolean = false;

    /**
     * 当前UI服务对应的数据服务对象
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */
    public dataService:OrmOrgsectorService = new OrmOrgsectorService();

    /**
     * 所有关联视图
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */ 
    public allViewMap: Map<string, Object> = new Map();

    /**
     * 状态值
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */ 
    public stateValue: number = 0;

    /**
     * 状态属性
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */ 
    public stateField: string = "";

    /**
     * 主状态属性集合
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */  
    public mainStateFields:Array<any> = [];

    /**
     * 主状态集合Map
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */  
    public allDeMainStateMap:Map<string,string> = new Map();

    /**
     * Creates an instance of  OrmOrgsectorUIServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  OrmOrgsectorUIServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.initViewMap();
        this.initDeMainStateMap();
    }

    /**
     * 初始化视图Map
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */  
    public initViewMap(){
        this.allViewMap.set(':',{viewname:'pxmbpickupview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'bmkqszgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'editview2',srfappde:'ormorgsectors'});
        this.allViewMap.set('MPICKUPVIEW:',{viewname:'mpickupview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'curzzbmkqszgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'bmbzglgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'bmbztreeexpview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'xmbbztreeexpview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'xmrlzyeditview',srfappde:'ormorgsectors'});
        this.allViewMap.set('REDIRECTVIEW:',{viewname:'redirectview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'curzzbm_kqszpickupview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'fpxxpickupgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'xmbbzgleditview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'bmbzgleditview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'curbmkqszgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'bmkqszeditview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'curzzbm_kqszpickupgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'xmbmgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set('PICKUPVIEW:',{viewname:'pickupview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'ydbmpickupgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'xmrlzygridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'pickupgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'kqsztreeexpview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'xmbbzglgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'editview9',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'xmbmeditview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'pxmbpickupgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set('MDATAVIEW:',{viewname:'gridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'xmbbzglcxeditview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'ydbmpickupview',srfappde:'ormorgsectors'});
        this.allViewMap.set('EDITVIEW:',{viewname:'editview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'kqszmpickupview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'setproleadereditview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'bzcxgridview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'fpxxpickupview',srfappde:'ormorgsectors'});
        this.allViewMap.set(':',{viewname:'editview9_editmode',srfappde:'ormorgsectors'});
    }

    /**
     * 初始化主状态集合
     * 
     * @memberof  OrmOrgsectorUIServiceBase
     */  
    public initDeMainStateMap(){
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
    public async OrmOrgsector_OpenEditView(args: any[], context:any = {} ,params: any={}, $event?: any, xData?: any,actionContext?:any,srfParentDeName?:string) {
    
        let data: any = {};
        let parentContext:any = {};
        let parentViewParam:any = {};
        const _this: any = actionContext;
        const _args: any[] = Util.deepCopy(args);
        const actionTarget: string | null = 'SINGLEKEY';
        Object.assign(context, { ormorgsector: '%ormorgsector%' });
        Object.assign(params, { orgsectorid: '%ormorgsector%' });
        Object.assign(params, { orgsectorname: '%orgsectorname%' });
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
                viewname: 'ormorgsectoredit-view9-edit-mode', 
                height: 0, 
                width: 0,  
                title: actionContext.$t('entities.ormorgsector.views.editview9_editmode.title'),
                placement: 'DRAWER_TOP',
            };
            openDrawer(view, data);
    }


    /**
     * 获取指定数据的重定向页面
     * 
     * @param srfkey 数据主键
     * @param isEnableWorkflow  重定向视图是否需要处理流程中的数据
     * @memberof  OrmOrgsectorUIServiceBase
     */
    public async getRDAppView(srfkey:string,isEnableWorkflow:boolean){
        this.isEnableWorkflow = isEnableWorkflow;
        // 进行数据查询
        let result:any = await this.dataService.Get({ormorgsector:srfkey});
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
     * @memberof  OrmOrgsectorUIServiceBase
	 */
	public getRealDEType(entity:any){

    }

    /**
     * 获取实体单数据实体视图预定义参数
     * 
     * @param curData 当前数据
     * @param bDataInWF 是否有数据在工作流中
     * @param bWFMode   是否工作流模式
     * @memberof  OrmOrgsectorUIServiceBase
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
     * @memberof  OrmOrgsectorUIServiceBase
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