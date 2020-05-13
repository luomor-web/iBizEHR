import { Environment } from '@/environments/environment';
import { UIActionTool,Util } from '@/utils';
import UIService from '../ui-service';
import { Subject } from 'rxjs';
import ARCHIVALCATALOGUEService from '@/service/archivalcatalogue/archivalcatalogue-service';

/**
 * 档案目录UI服务对象基类
 *
 * @export
 * @class ARCHIVALCATALOGUEUIServiceBase
 */
export default class ARCHIVALCATALOGUEUIServiceBase extends UIService {

    /**
     * 是否支持工作流
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */
    protected isEnableWorkflow:boolean = false;

    /**
     * 当前UI服务对应的数据服务对象
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */
    protected dataService:ARCHIVALCATALOGUEService = new ARCHIVALCATALOGUEService();

    /**
     * 所有关联视图
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */ 
    protected allViewMap: Map<string, Object> = new Map();

    /**
     * 状态值
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */ 
    protected stateValue: number = 0;

    /**
     * 状态属性
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */ 
    protected stateField: string = "";

    /**
     * 主状态属性集合
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */  
    protected mainStateFields:Array<any> = [];

    /**
     * 主状态集合Map
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */  
    protected allDeMainStateMap:Map<string,string> = new Map();

    /**
     * Creates an instance of  ARCHIVALCATALOGUEUIServiceBase.
     * 
     * @param {*} [opts={}]
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */
    constructor(opts: any = {}) {
        super(opts);
        this.initViewMap();
        this.initDeMainStateMap();
    }

    /**
     * 初始化视图Map
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */  
    public initViewMap(){
        this.allViewMap.set('EDITVIEW:',{viewname:'editview',srfappde:'archivalcatalogues'});
        this.allViewMap.set(':',{viewname:'pickupgridview',srfappde:'archivalcatalogues'});
        this.allViewMap.set('PICKUPVIEW:',{viewname:'pickupview',srfappde:'archivalcatalogues'});
        this.allViewMap.set('MPICKUPVIEW:',{viewname:'mpickupview',srfappde:'archivalcatalogues'});
        this.allViewMap.set('REDIRECTVIEW:',{viewname:'redirectview',srfappde:'archivalcatalogues'});
        this.allViewMap.set('MDATAVIEW:',{viewname:'gridview',srfappde:'archivalcatalogues'});
        this.allViewMap.set(':',{viewname:'editview2',srfappde:'archivalcatalogues'});
    }

    /**
     * 初始化主状态集合
     * 
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */  
    public initDeMainStateMap(){
    }


    /**
     * 获取指定数据的重定向页面
     * 
     * @param srfkey 数据主键
     * @param isEnableWorkflow  重定向视图是否需要处理流程中的数据
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
     */
    public async getRDAppView(srfkey:string,isEnableWorkflow:boolean){
        this.isEnableWorkflow = isEnableWorkflow;
        // 进行数据查询
        let result:any = await this.dataService.Get({archivalcatalogue:srfkey});
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
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
	 */
	protected getRealDEType(entity:any){

    }

    /**
     * 获取实体单数据实体视图预定义参数
     * 
     * @param curData 当前数据
     * @param bDataInWF 是否有数据在工作流中
     * @param bWFMode   是否工作流模式
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
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
     * @memberof  ARCHIVALCATALOGUEUIServiceBase
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