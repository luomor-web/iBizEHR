<template>
    <div class="app-data-chart ">
        <div class="app-charts" :id="chartId" style="height: 300px;padding: 6px 0;"></div>
  </div>
</template>


<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PimPersonService from '@/service/pim-person/pim-person-service';
import OrgPersonOrgTypeService from './org-person-org-type-chart-service';

import echarts from 'echarts';
import moment from "moment"; 
import CodeListService from "@service/app/codelist-service";
import { ChartDataSetField,ChartLineSeries,ChartFunnelSeries,ChartPieSeries,ChartBarSeries,ChartRadarSeries} from '@/model/chart-detail';


@Component({
    components: {
      
    }
})
export default class OrgPersonOrgTypeBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof OrgPersonOrgType
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof OrgPersonOrgType
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof OrgPersonOrgType
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof OrgPersonOrgType
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof OrgPersonOrgType
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof OrgPersonOrgType
     */
    public getControlType(): string {
        return 'CHART'
    }



    /**
     * 建构部件服务对象
     *
     * @type {OrgPersonOrgTypeService}
     * @memberof OrgPersonOrgType
     */
    public service: OrgPersonOrgTypeService = new OrgPersonOrgTypeService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PimPersonService}
     * @memberof OrgPersonOrgType
     */
    public appEntityService: PimPersonService = new PimPersonService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof OrgPersonOrgType
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof OrgPersonOrgType
     */
    public counterRefresh(){
        const _this:any =this;
        if(_this.counterServiceArray && _this.counterServiceArray.length >0){
            _this.counterServiceArray.forEach((item:any) =>{
                if(item.refreshData && item.refreshData instanceof Function){
                    item.refreshData();
                }
            })
        }
    }


    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof OrgPersonOrgType
     */
    public getDatas(): any[] {
        return [];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof OrgPersonOrgType
     */
    public getData(): any {
        return null;
    }

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof OrgPersonOrgType
     */
    @Prop({ default: true }) public showBusyIndicator!: boolean;

    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof OrgPersonOrgType
     */
    @Prop() public fetchAction!: string;  

    /**
    * Vue声明周期(组件初始化完毕)
    *
    * @memberof OrgPersonOrgType
    */
    public created() {
         this.afterCreated();     
    }

    /**
    * 执行created后的逻辑
    *
    * @memberof OrgPersonOrgType
    */
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('load', action)) {
                    this.load(data);
                }
            });
        }  
    }

    /**
     * vue 生命周期
     *
     * @memberof OrgPersonOrgType
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof OrgPersonOrgType
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 图表div绑定的id
     *
     * @type {}
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */   
    public chartId:string = this.$util.createUUID();

    /**
     * echarts图表对象
     *
     * @type {}
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */   
    public myChart:any;

    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 序列模型
     *
     * @type {}
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public  seriesModel:any = {
        orgpersonorgtypepie:new ChartPieSeries({
    name:'orgpersonorgtypepie',
    
    
    categorField:'ormtype',
    categorCodeList:{type:'STATIC',tag:'EhrCodeList0083',emptycode:'empty',emptytext:'未定义'},
    valueField:'countnum',
    seriesValues:[],
    seriesIndex:0,
    data:[],
    seriesMap:{},
    dataSetFields:[
    {name:"ormtype",codelist:{type:"STATIC",tag:"EhrCodeList0083",emptycode:'empty',emptytext:'未定义'},isGroupField:true,groupMode:"CODELIST"},
    {name:"countnum",codelist:null,isGroupField:false,groupMode:""}
    ],
    ecxObject:{
        label:{
            show: true,
            position: 'outside',
        },
        labelLine:{
            show: true,
            length: 10,
            lineStyle: {
                width: 1,
                type: 'solid'
            }
        },
        itemStyle:{
            borderColor: '#fff',
            borderWidth: 1
        },
        emphasis:{
            label: {
                fontSize: 20
            }
        }
    },
    ecObject:{
        label:{formatter:"{b}: {@countnum}人"},
        radius:['50%', '70%'],
        legend:{formatter:"{a}: {@countnum}人"},
    },
    seriesTemp:{
        type:'pie',
    },
    baseOption:{
    },
    seriesLayoutBy:"column"
    })

    };

    /**
     * 图表自定义参数集合
     *
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */   
    public chartUserParams:any ={
        legend:{show: true,left:"left",top:"75%",orient: 'vertical',},
        color:["#f69f54","#00ffa9","#aa00ff","#884bff",'#42B3FF','#85B3FF','#A1FFFF']
    };

    /**
     * 图表基础动态模型
     *
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */  
    public chartBaseOPtion:any = {};

    /**
     * 初始化图表所需参数
     *
     * @type {}
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */   
    public chartOption:any = {
        title:{
            show:true ,
            text:'机关与项目人员',
            subtext:''
        },
        legend:{
            show:false
        },
        tooltip:{
            show:true
        },
        dataset:[],
        series:[
                     {
            id:'orgpersonorgtypepie',
            name:'机关与项目人员',
            type:'pie',
            datasetIndex:0,
            
            seriesLayoutBy:"column",
            encode:{
                itemName:"ormtype",
                value:"countnum"
            }}
        ]
    };

    /**
     * 刷新
     *
     * @param {*} [opt={}]
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public refresh(opt: any = {}) {
        this.load(opt);
    }

    /**
     * 获取图表数据
     * 
     * @returns {*} 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public load(opt?:any) {
        let _this = this;
        const arg: any = { ...opt };
        const parentdata: any = {};
        this.$emit('beforeload', parentdata);
        Object.assign(arg, parentdata);
        Object.assign(arg,{viewparams:this.viewparams,page:0,size:1000});
        this.service.search(this.fetchAction,JSON.parse(JSON.stringify(this.context)),arg,this.showBusyIndicator).then((res) => {
            if (res) {
               this.transformToBasicChartSetData(res.data,() =>{_this.drawCharts()});
            }
        }).catch((error) => {
            console.error(error);
        });
    }

    /**
     * 绘制图表
     * 
     * @returns {*} 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public drawCharts(){
        if(!this.myChart){
          let element:any =  document.getElementById(this.chartId);
          this.myChart = echarts.init(element);
        }
        this.handleChartOPtion();
        console.log(this.chartOption);
        this.myChart.setOption(this.chartOption);
        this.myChart.resize();
    }

    /**
     * 处理图表参数
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public handleChartOPtion(){
        if(Object.keys(this.seriesModel).length > 0){
            let tempDataSourceMap:Map<string,any> = new Map();
            for(let i=0;i<Object.keys(this.seriesModel).length;i++){
                Object.values(this.seriesModel).forEach((seriesvalue:any) =>{
                    if(seriesvalue.seriesIndex === i){
                        tempDataSourceMap.set(seriesvalue.name,seriesvalue.data);
                    }
                })
            }
            if(tempDataSourceMap.size > 0){
                tempDataSourceMap.forEach((item:any) =>{
                    this.chartOption.dataset.push({'source':item});
                })
            }
            Object.keys(this.seriesModel).forEach((seriesName:string) =>{
                if(this.chartOption && this.chartOption.series.length > 0){
                    this.chartOption.series.forEach((item:any) =>{
                        if(this.seriesModel[seriesName].ecxObject){
                            item = Util.deepObjectMerge(item,this.seriesModel[seriesName].ecxObject);
                        }
                        if(this.seriesModel[seriesName].baseOption && Object.keys(this.seriesModel[seriesName].baseOption).length > 0){
                            item = Util.deepObjectMerge(item,this.seriesModel[seriesName].baseOption);
                        }
                        if(this.seriesModel[seriesName].ecObject){
                            item = Util.deepObjectMerge(item,this.seriesModel[seriesName].ecObject);
                        }
                    })
                }
                //设置多序列
                let tempSeries:any = this.seriesModel[seriesName];
                // 雷达图
                if(tempSeries.type && Object.is(tempSeries.type,'radar') && tempSeries.seriesIdField && tempSeries.seriesValues.length > 0){
                    let tempIndicator:any = [];
                    tempSeries.seriesValues.forEach((item:any) =>{
                        let singleIndicatorObj:any = {name:item,max:100};
                        tempIndicator.push(singleIndicatorObj);
                    })
                    this.chartOption.radar = {'indicator':tempIndicator};
                }else{
                    // 非雷达图
                    if(tempSeries && tempSeries.seriesIdField && tempSeries.seriesValues.length > 0){
                        const returnIndex:number = this.chartOption.series.findIndex((item:any) =>{
                            return Object.is(item.id,seriesName);
                        })
                        this.chartOption.series.splice(returnIndex,1);
                        let tempSeriesArray:Array<any> = [];
                        tempSeries.seriesValues.forEach((seriesvalueItem:any) =>{
                            let tempSeriesTemp:any = JSON.parse(JSON.stringify(tempSeries.seriesTemp));
                            Object.assign(tempSeriesTemp,{name:tempSeries.seriesMap[seriesvalueItem],datasetIndex:tempSeries.seriesIndex,encode:{x:tempSeries.categorField,y:`${seriesvalueItem}`}});
                            this.chartOption.series.push(tempSeriesTemp);
                        })
                    }
                }
            })
        }
        if(Object.keys(this.chartBaseOPtion).length > 0){
            Object.assign(this.chartOption,this.chartBaseOPtion);
        }
        if(Object.keys(this.chartUserParams).length >0){
            Object.assign(this.chartOption,this.chartUserParams);
        }
    }

    /**
     * 实体数据集转化为图表数据集
     * 
     * 1.获取图表所有代码表值
     * 2.查询集合映射图表数据集
     * 3.补全图表数据集
     * 4.图表数据集分组求和
     * 5.排序图表数据集
     * 
     * @param {*} data 实体数据集
     * @param {Function} callback 回调
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public async transformToBasicChartSetData(data:any,callback:Function){
        if(!data || !Array.isArray(data) || data.length === 0){
            return;
        }
        //获取代码表值
        let allCodeList:any = await this.getChartAllCodeList();
        if(Object.values(this.seriesModel).length > 0){
            Object.values(this.seriesModel).forEach((singleSeries:any,index:number) =>{
                // 值属性为srfcount设置{srfcount:1}到data
                let valueField = singleSeries.dataSetFields.find((datasetField:any) =>{
                    return datasetField.name === singleSeries.valueField;
                }); 
                if(valueField && valueField.name && Object.is(valueField.name,"srfcount")){
                    data.forEach((singleData:any) =>{
                        Object.assign(singleData,{srfcount:1});
                    })
                }
                // 分组属性
                let groupField = singleSeries.dataSetFields.find((datasetField:any) =>{
                    return datasetField.name === singleSeries.categorField;
                }); 
                let tempChartSetData:Array<any> = [];
                let tempSeriesValues:Map<string,any> = new Map();
                data.forEach((item:any) =>{
                    let tempChartSetDataItem:any = {};
                    // 序列属性不存在
                    if(!singleSeries.seriesIdField){
                        Object.assign(tempChartSetDataItem,{name:singleSeries.name});
                        if(singleSeries.dataSetFields && singleSeries.dataSetFields.length >0){
                            singleSeries.dataSetFields.forEach((singleDataSetField:any) =>{
                                this.handleSingleDataSetField(item,singleDataSetField,allCodeList,tempChartSetDataItem,groupField);
                            })
                        }
                    }else{
                        // 序列属性存在时
                        let tempSeriesValueItem = tempSeriesValues.get(item[singleSeries.seriesIdField]);
                        if(!tempSeriesValueItem){
                            tempSeriesValues.set(item[singleSeries.seriesIdField],item[singleSeries.seriesNameField]);
                        }
                        Object.assign(tempChartSetDataItem,{name:item[singleSeries.seriesIdField]});
                        if(singleSeries.dataSetFields && singleSeries.dataSetFields.length >0){
                            singleSeries.dataSetFields.forEach((singleDataSetField:any) =>{
                                this.handleSingleDataSetField(item,singleDataSetField,allCodeList,tempChartSetDataItem,groupField);
                            })
                        }
                    }
                    tempChartSetData.push(tempChartSetDataItem);
                })
                // 补全数据集合
                this.completeDataSet(tempChartSetData,singleSeries,allCodeList);
                singleSeries.seriesValues = [...tempSeriesValues.keys()];
                let tempSeriesMapObj:any = {};
                tempSeriesValues.forEach((value:any,key:any) =>{
                    tempSeriesMapObj[key] = value;
                })
                singleSeries.seriesMap = tempSeriesMapObj;
                let callbackFunction:any = (index === (Object.values(this.seriesModel).length - 1))?callback:null;
                this.transformToChartSeriesDataSet(tempChartSetData,singleSeries,callbackFunction,allCodeList);
            })
        }
    }

    /**
     * 构建图表序列数据集合
     * 
     * 1.分组求和
     * 2.排序求和数组
     * 
     * @param {Array<any>} data 传入数据
     * @param {Array<any>} item 单个序列
     * @param {Array<any>} callback 回调
     * @param {*} allCodeList 所有代码表
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public transformToChartSeriesDataSet(data:any,item:any,callback:Function,allCodeList:any):any{
        if(item.seriesIdField){
            // 多序列
            let groupField = item.dataSetFields.filter((datasetField:any) =>{
                return datasetField.name === item.categorField;
            });
            let tempGroupField:Array<any> = groupField.map((item:any) =>{
                return item.name;
            });
            let seriesField = item.dataSetFields.filter((datasetField:any) =>{
                return datasetField.name === item.seriesIdField;
            });
            let tempSeriesField:Array<any> = seriesField.map((item:any) =>{
                return item.name;
            });
            let valueField = item.dataSetFields.filter((datasetField:any) =>{
                return datasetField.name === item.valueField;
            });
            let tempValueField:Array<any> = valueField.map((item:any) =>{
                return item.name;
            });
            item.data = this.groupAndAdd(tempGroupField,tempSeriesField,tempValueField,data,item,groupField,allCodeList);
        }else{
            //单序列
            let groupField = item.dataSetFields.filter((datasetField:any) =>{
                return datasetField.name === item.categorField;
            });
            let tempGroupField:Array<any> = groupField.map((item:any) =>{
                return item.name;
            })
            let valueField = item.dataSetFields.filter((datasetField:any) =>{
                return datasetField.name === item.valueField;
            });
            let tempValueField:Array<any> = valueField.map((item:any) =>{
                return item.name;
            })
            item.data = this.groupAndAdd(tempGroupField,[],tempValueField,data,item,groupField,allCodeList);
        }
        if(callback && callback instanceof Function){
            callback();
        }
    }

    /**
     * 分组和求和  
     * @param {Array<any>} groupField 分组属性
     * @param {Array<any>} groupField 值属性
     * @param {Array<any>} data 传入数据
     * @param {*} groupFieldModel 分组属性模型
     * @param {*} allCodeList 所有代码表
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public groupAndAdd(groupField:Array<any>,seriesField:Array<any>,valueField:Array<any>,data:any,item:any,groupFieldModel:any,allCodeList:any){
        let tempMap:Map<string,any> = new Map();
        let groupMode:string = groupFieldModel[0].groupMode;
        let groupKeyStr:string = "";
        data.forEach((item:any) =>{
            let tempGroupField:string = groupField[0];
            groupKeyStr = item[tempGroupField];
            let tempMapItem:any = tempMap.get(groupKeyStr);
            if(tempMapItem){
                tempMapItem.push(item);
                tempMap.set(groupKeyStr,tempMapItem);
            }else{
                tempMap.set(groupKeyStr,[item]);
            }
        })
        // 处理多序列
        if(seriesField.length > 0 && tempMap.size > 0){
            let tempSeriesField:string = seriesField[0];
            tempMap.forEach((item:any,key:string) =>{
                let tempItemMap:Map<string,any> = new Map();
                item.forEach((singleItem:any)=>{
                    let seriesValueArray:any = tempItemMap.get(singleItem[tempSeriesField]);
                    if(seriesValueArray){
                        seriesValueArray.push(singleItem);
                        tempItemMap.set(singleItem[tempSeriesField],seriesValueArray);
                    }else{
                        tempItemMap.set(singleItem[tempSeriesField],[singleItem]);
                    }
                })
                tempMap.set(key,tempItemMap);
            });
        }
        let returnArray:Array<any> = [];
        if(seriesField.length == 0){
            //单序列
            tempMap.forEach((tempItem:any) =>{
                if(tempItem.length >0){
                    let curObject:any = {};
                    let valueResult:number = 0;
                    let categorResult:any;
                    tempItem.forEach((singleItem:any) =>{
                        categorResult = singleItem[groupField[0]];
                        valueResult += singleItem[valueField[0]];
                    })
                    Object.defineProperty(curObject, groupField[0], {
                        value: categorResult,
                        writable : true,
                        enumerable : true,
                        configurable : true
                    });
                    Object.defineProperty(curObject, valueField[0], {
                        value: valueResult,
                        writable : true,
                        enumerable : true,
                        configurable : true
                    });
                    returnArray.push(curObject);
                }
            })
        }else{
            // 多序列
            let seriesValuesArray:Array<any> = item.seriesValues;
            tempMap.forEach((groupItem:any,groupKey:string) =>{
                //求和
                let curObject:any = {};
                Object.defineProperty(curObject, groupField[0], {
                    value: groupKey,
                    writable : true,
                    enumerable : true,
                    configurable : true
                });
                seriesValuesArray.forEach((seriesValueItem:any) =>{
                    Object.defineProperty(curObject, seriesValueItem, {
                        value: 0,
                        writable : true,
                        enumerable : true,
                        configurable : true
                    });
                });
                groupItem.forEach((seriesItem:any,seriesKey:string) =>{
                    let seriesNum:number = 0;
                    seriesItem.forEach((dataItem:any) =>{
                        seriesNum += dataItem[valueField[0]];
                    })
                    curObject[seriesKey] = seriesNum; 
                })
                returnArray.push(curObject);
            })
        }
        // 补全空白分类
        if(returnArray.length >0){
            let emptyText = (groupFieldModel[0] && groupFieldModel[0].codeList)?groupFieldModel[0].codeList.emptytext:"未定义";
            returnArray.forEach((item:any) =>{
                if(!item[groupField[0]]){
                    item[groupField[0]] = emptyText;
                }
            })
        }
        returnArray = this.sortReturnArray(returnArray,groupFieldModel,allCodeList);
        // 雷达图数据格式处理
        if(Object.is(item.type,'radar')){
            returnArray.forEach((item:any) =>{
                item.type = item[groupField[0]];
                delete item[groupField[0]];
            })
        }
        console.log(JSON.stringify(returnArray));
        return returnArray;
    }

    /**
     * 排序数组
     * 
     * @param {Array<any>} arr 传入数组
     * @param {*} groupField 分组属性
     * @param {*} allCodeList 所有代码表
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public sortReturnArray(arr:Array<any>,groupField:any,allCodeList:any){
        let returnArray:Array<any> = [];
        // todo
        // 分组属性有代码表的情况(最后执行)
        if(groupField[0].codelist){
            let curCodeList:Map<number,any> = allCodeList.get(groupField[0].codelist.tag);
            curCodeList.forEach((codelist:any) =>{
                arr.forEach((item:any) =>{
                    if(Object.is(item[groupField[0].name],codelist)){
                        returnArray.push(item);
                        item.hasused = true;
                    }
                })
            })
            arr.forEach((item:any,index:number) =>{
                if(!item.hasused){
                    returnArray.push(item);
                }
            })
            returnArray.forEach((item:any) =>{
                delete item.hasused;
            })
        }else{
            // 分组为年份
            if(Object.is(groupField[0].groupMode,"YEAR")){
                returnArray = arr.sort((a:any, b:any) => {
                    return Number(a[groupField[0].name]) - Number(b[groupField[0].name]);
                });
            }else if(Object.is(groupField[0].groupMode,"QUARTER")){
                returnArray = this.handleSortGroupData(arr,groupField,"季度");
            }else if(Object.is(groupField[0].groupMode,"MONTH")){
                returnArray = this.handleSortGroupData(arr,groupField,"月");
            }else if(Object.is(groupField[0].groupMode,"YEARWEEK")){
                returnArray = this.handleSortGroupData(arr,groupField,"周");
            }else if(Object.is(groupField[0].groupMode,"DAY")){
                returnArray = arr.sort((a:any, b:any) => {
                    return moment(a[groupField[0].name]).unix() - moment(b[groupField[0].name]).unix();
                });
            }else{
                let groupFieldName:string = groupField[0].name;
                let isConvert:boolean = true;
                arr.forEach((item:any) =>{
                    if(isNaN(item[groupFieldName])){
                        isConvert = false;
                    }
                })
                if(isConvert){
                    returnArray = arr.sort((a:any, b:any) => {
                        return a[groupFieldName] - b[groupFieldName];
                    });
                }else{
                    returnArray = arr;
                }
            }
        }
        return returnArray;
    }

    /**
     * 排序分组模式下的数据
     * 
     * @param {Array<any>} arr 传入数据
     * @param {Array<any>} groupField 分组属性
     * @param {Array<any>} label label标签
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public handleSortGroupData(arr:Array<any>,groupField:any,label:string){
        arr.forEach((item:any) =>{
            let sortFieldValue:Array<any> = item[groupField[0].name].split("-");
            Object.assign(item,{sortField:Number(sortFieldValue[0])*10000+Number(sortFieldValue[1])});
            item[groupField[0].name] = sortFieldValue[0]+"年"+sortFieldValue[1]+label;
        })
        arr.sort((a:any, b:any) => {
            return Number(a.sortField) - Number(b.sortField);
        });
        arr.forEach((item:any) =>{
            delete item.sortField;
        })
        return arr;
    }

    /**
     * 补全数据集
     * 
     * @param {Array<any>} data 传入数据
     * @param {Array<any>} item 单个序列
     * @param {Array<any>} allCodeList 所有的代码表
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public completeDataSet(data:any,item:any,allCodeList:any){
        // 分组属性
        let groupField = item.dataSetFields.find((datasetField:any) =>{
            return datasetField.name === item.categorField;
        });
        if(Object.is(groupField.groupMode,"")){
            return;
        }
        //分组模式为代码表（补值）
        if(Object.is(groupField.groupMode,'CODELIST')){
            this.completeCodeList(data,item,allCodeList);
        }
        //分组模式为年/季度/月份（最大值，最小值，分组，补值）
        if(Object.is(groupField.groupMode,"YEAR") || Object.is(groupField.groupMode,"QUARTER") || Object.is(groupField.groupMode,"MONTH") || Object.is(groupField.groupMode,"YEARWEEK")  || Object.is(groupField.groupMode,"DAY")){
            this.handleTimeData(data,item,allCodeList,groupField);
        }
    }

    /**
     * 获取最大值最小值
     * 
     * @param {Array<any>} tempTimeArray 传入数据
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public  getRangeData(tempTimeArray:Array<any>){
        tempTimeArray.forEach((item:any) =>{
            let tempParams:Array<any> = item._i.split("-");
            item.sortField = Number(tempParams[0] + tempParams[1]);
        })
        tempTimeArray.sort((a:any, b:any) => {
            return Number(a.sortField) - Number(b.sortField);
        });
        tempTimeArray.forEach((item:any) =>{
            delete item.sortField;
        })
        return tempTimeArray;
    }

   /**
     * 补全时间类型数据集
     * 
     * @param {Array<any>} data 传入数据
     * @param {Array<any>} item 单个序列
     * @param {Array<any>} allCodeList 所有的代码表
     * @param {Array<any>} groupField 分组属性
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public handleTimeData(data:any,item:any,allCodeList:any,groupField:any){
        let valueField = item.dataSetFields.find((datasetField:any) =>{
            return datasetField.name === item.valueField;
        });
        let groupMode:string = groupField.groupMode;
        // 排序数据，找到最大值、最小值
        let tempTimeArray:Array<any> = [];
        if(data && data.length >0){
            data.forEach((dataItem:any) =>{
                // 判断时间类型是否为空，为空不处理
                if(dataItem[groupField.name]){
                    tempTimeArray.push(moment(dataItem[groupField.name]));
                }
            })
        }
        let maxTime:any;
        let minTime:any;
        if(Object.is(groupMode,"YEAR") || Object.is(groupMode,"DAY")){
            maxTime = moment.max(tempTimeArray);
            minTime = moment.min(tempTimeArray);
        }
        if(Object.is(groupMode,"QUARTER")){
            tempTimeArray = this.getRangeData(tempTimeArray);
            minTime = moment().year((tempTimeArray[0]._i.split("-"))[0]).quarters((tempTimeArray[0]._i.split("-"))[1]);
            maxTime = moment().year((tempTimeArray[tempTimeArray.length - 1]._i.split("-"))[0]).quarters((tempTimeArray[tempTimeArray.length - 1]._i.split("-"))[1]);
        }
        if(Object.is(groupMode,"MONTH")){
            tempTimeArray = this.getRangeData(tempTimeArray);
            minTime = moment().year((tempTimeArray[0]._i.split("-"))[0]).month((tempTimeArray[0]._i.split("-"))[1]);
            maxTime = moment().year((tempTimeArray[tempTimeArray.length - 1]._i.split("-"))[0]).month((tempTimeArray[tempTimeArray.length - 1]._i.split("-"))[1]);
        }
        if(Object.is(groupMode,"YEARWEEK")){
            tempTimeArray = this.getRangeData(tempTimeArray);
            minTime = moment().year((tempTimeArray[0]._i.split("-"))[0]).week((tempTimeArray[0]._i.split("-"))[1]);
            maxTime = moment().year((tempTimeArray[tempTimeArray.length - 1]._i.split("-"))[0]).week((tempTimeArray[tempTimeArray.length - 1]._i.split("-"))[1]);
        }
        let timeFragmentArray:Array<any> = [];
        let tempGrounpData:Map<string,any> = new Map();
        // 时间分段
        //groupMode为"YEAR"
        if(Object.is(groupMode,"YEAR")){
            let curTime:any = minTime;
            while(curTime){
                if(curTime.isSameOrBefore(maxTime)){
                    let tempcurTime:any = curTime.clone();
                    timeFragmentArray.push(tempcurTime.year().toString());
                    curTime = tempcurTime.clone().add(1, 'years');
                }else{
                    curTime = null;
                }
            }
        }
        //groupMode为"QUARTER"
        if(Object.is(groupMode,"QUARTER")){
            let curTime:any = minTime;
            while(curTime){
                if(curTime.isSameOrBefore(maxTime)){
                    let tempcurTime:any = curTime.clone();
                    timeFragmentArray.push(tempcurTime.year().toString()+"-"+tempcurTime.quarter().toString());
                    curTime = tempcurTime.clone().add(1, 'quarters');
                }else{
                    curTime = null;
                }
            }
        }
        //groupMode为"MONTH"
        if(Object.is(groupMode,"MONTH")){
            let curTime:any = minTime;
            while(curTime){
                if(curTime.isSameOrBefore(maxTime)){
                    let tempcurTime:any = curTime.clone();
                    timeFragmentArray.push(tempcurTime.year().toString()+"-"+tempcurTime.month().toString());
                    curTime = tempcurTime.clone().add(1, 'months');
                }else{
                    curTime = null;
                }
            }
        }
        //groupMode为"YEARWEEK"
        if(Object.is(groupMode,"YEARWEEK")){
            let curTime:any = minTime;
            while(curTime){
                if(curTime.isSameOrBefore(maxTime)){
                    let tempcurTime:any = curTime.clone();
                    timeFragmentArray.push(tempcurTime.year().toString()+"-"+tempcurTime.week().toString());
                    curTime = tempcurTime.clone().add(1, 'weeks');
                }else{
                    curTime = null;
                }
            }
        }
        //groupMode为"DAY"
        if(Object.is(groupMode,"DAY")){
            let curTime:any = minTime;
            while(curTime){
                if(curTime.isSameOrBefore(maxTime)){
                    let tempcurTime:any = curTime.clone();
                    timeFragmentArray.push(tempcurTime.format('YYYY-MM-DD'));
                    curTime = tempcurTime.clone().add(1, 'days');
                }else{
                    curTime = null;
                }
            }
        }
        data.forEach((item:any) =>{
            let tempKeyStr:string = item[groupField.name];
            let tempGrounpItem:any = tempGrounpData.get(tempKeyStr);
            if(!tempGrounpItem){
                tempGrounpData.set(tempKeyStr,item);
            }
        })
        timeFragmentArray.forEach((timeFragment:any) =>{
            if(!tempGrounpData.get(timeFragment)){
                let copyTemp:any = JSON.parse(JSON.stringify(data[0]));
                let curObj:any = {};
                curObj[groupField.name] = timeFragment;
                curObj[valueField.name] = 0;
                Object.assign(copyTemp,curObj);
                data.push(copyTemp);
            }
        })
    }

    /**
     * 补全代码表
     * 
     * @param {Array<any>} data 传入数据
     * @param {Array<any>} item 单个序列
     * @param {Array<any>} allCodeList 所有的代码表
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public  completeCodeList(data:any,item:any,allCodeList:any){
        let groupField = item.dataSetFields.find((datasetField:any) =>{
            return datasetField.name === item.categorField;
        });
        if(!groupField.codelist){
            return;
        }
        let valueField = item.dataSetFields.find((datasetField:any) =>{
            return datasetField.name === item.valueField;
        });
        let curCodeList:Map<number,any> = allCodeList.get(groupField.codelist.tag);
        // 对分类实现分组
        let tempGrounpData:Map<string,any> = new Map();
        data.forEach((item:any) =>{
            let tempGrounpItem:any = tempGrounpData.get(item[groupField.name+'_srfvalue']);
            if(!tempGrounpItem){
                tempGrounpData.set(item[groupField.name+'_srfvalue'],item);
            }
        })
        if(curCodeList.size !== tempGrounpData.size){
            curCodeList.forEach((text:any,value:any) =>{
                if(!tempGrounpData.get(value)){
                    let copyTemp:any = JSON.parse(JSON.stringify(data[0]));
                    let curObj:any = {};
                    curObj[groupField.name+'_srfvalue'] = value;
                    curObj[groupField.name] = text;
                    curObj[valueField.name] = 0;
                    Object.assign(copyTemp,curObj);
                    data.push(copyTemp);
                }
            })
        }  
    }

    /**
     * 处理单个属性
     * 
     * @param {*} input 输入值
     * @param {*} field 属性值
     * @param {*} allCodeList 所有代码表
     * @param {*} result 结果值
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public handleSingleDataSetField(input:any,field:any,allCodeList:any,result:any,groupField:any){
        let tempFieldObj:any = {};
        //存在代码表的情况(自动转化值)
        if(field.codelist){
            //获取代码表
            let curCodeList:Map<number,any> = allCodeList.get(field.codelist.tag);
            tempFieldObj[field.name] = curCodeList.get(input[field.name]);
            tempFieldObj[field.name+'_srfvalue'] = input[field.name];
        }else{
             // 不存在代码表的情况
            if(groupField && Object.is(groupField.name,field.name)){
                if(Object.is(groupField.groupMode,"YEAR") ){
                    tempFieldObj[field.name] = moment(input[field.name]).year().toString();
                }else if(Object.is(groupField.groupMode,"QUARTER") ){
                    tempFieldObj[field.name] = moment(input[field.name]).year().toString()+"-"+moment(input[field.name]).quarters().toString();
                }else if(Object.is(groupField.groupMode,"MONTH") ){
                    tempFieldObj[field.name] = moment(input[field.name]).year().toString()+"-"+moment(input[field.name]).month().toString();
                }else if(Object.is(groupField.groupMode,"YEARWEEK") ){
                    tempFieldObj[field.name] = moment(input[field.name]).year().toString()+"-"+moment(input[field.name]).week().toString();
                }else if(Object.is(groupField.groupMode,"DAY") ){
                    tempFieldObj[field.name] = moment(input[field.name]).format("YYYY-MM-DD");
                }else{
                    tempFieldObj[field.name] = input[field.name];
                }
            }else{
                tempFieldObj[field.name] = input[field.name]
            }
        }
        Object.assign(result,tempFieldObj);
    }

    /**
     * 获取图表所需代码表
     * 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public getChartAllCodeList():Promise<any>{
        return new Promise((resolve:any,reject:any) =>{
            let codeListMap:Map<string,any> = new Map();
            if(Object.values(this.seriesModel).length >0){
                let tempFlag:boolean = true;
                Object.values(this.seriesModel).forEach((singleSeries:any) =>{
                    if(singleSeries.dataSetFields && singleSeries.dataSetFields.length >0){
                        let promiseArray:Array<any> = [];
                        let promiseKeyArray:Array<any> = [];
                        singleSeries.dataSetFields.forEach((singleDataSetField:any,index:any) =>{
                            if(singleDataSetField.codelist){
                                tempFlag = false;
                                if(!codeListMap.get(singleDataSetField.codelist.tag)){
                                    promiseArray.push(this.getCodeList(singleDataSetField.codelist));
                                    promiseKeyArray.push(singleDataSetField.codelist.tag);
                                    Promise.all(promiseArray).then((result:any) =>{
                                        if(result && result.length >0){
                                            result.forEach((codeList:any) =>{
                                                let tempCodeListMap:Map<number,any> = new Map();
                                                if(codeList.length >0){
                                                    codeList.forEach((codeListItem:any) =>{
                                                        tempCodeListMap.set(codeListItem.value,codeListItem.text);
                                                    })
                                                }
                                                codeListMap.set(singleDataSetField.codelist.tag,tempCodeListMap);       
                                            })
                                            resolve(codeListMap);
                                        }
                                    })
                                }
                            }
                        })
                    }
                })
                if(tempFlag){resolve(codeListMap);}
            }else{
                resolve(codeListMap);
            }
        })
    }

    /**
     * 获取代码表
     * 
     * @returns {Promise<any>} 
     * @memberof Portlet_OrgPersonOrgTypePie_chartBase
     */
    public getCodeList(codeListObject:any):Promise<any>{
        return new Promise((resolve:any,reject:any) =>{
            if(codeListObject.tag && Object.is(codeListObject.type,"STATIC")){
                const codelist = this.$store.getters.getCodeList(codeListObject.tag);
                if (codelist) {
                    resolve([...JSON.parse(JSON.stringify(codelist.items))]);
                } else {
                    console.log(`----${codeListObject.tag}----代码表不存在`);
                }
            }else if(codeListObject.tag && Object.is(codeListObject.type,"DYNAMIC")){
                this.codeListService.getItems(codeListObject.tag).then((res:any) => {
                    resolve(res);
                }).catch((error:any) => {
                    console.log(`----${codeListObject.tag}----代码表不存在`);
                });
            }
        })
    }


}
</script>

<style lang='less'>
@import './org-person-org-type-chart.less';
</style>