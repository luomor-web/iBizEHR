<template>
    <div class="app-data-upload-view">
        <el-row :gutter="20">
            <el-col :span="4">
                <el-button type="primary" @click="handleUpLoad">{{$t('components.appDataUploadView.selectfile')}}</el-button>
                <input ref="inputUpLoad" type="file" style="display: none" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" @change="importFile"/>
            </el-col>
            <el-col :span="4">
                <el-button type="primary" @click="uploadServer">{{$t('components.appDataUploadView.uploadserver')}}</el-button>
            </el-col>
            <el-col :span="16">
                <div class="import-temp"><span style="cursor: pointer;" @click="downloadTemp">{{$t('components.appDataUploadView.datatemplate')}}</span></div>
            </el-col>
        </el-row>
        <el-divider></el-divider>
        <el-row style="height:calc(100% - 128px);padding: 0px 12px;">
            <div class="data-info-content" >
                <template v-if="importDataArray.length >0 && isUploading === false">
                    <ul>
                        <li v-for="(item,index) in importDataArray" :key="index" class="font-class">
                            {{$t('components.appDataUploadView.dataid')+item[importUniqueItem]+$t('components.appDataUploadView.read')+'......'}}
                        </li>
                    </ul>
                </template>
                <template v-if="hasImported === true && importDataArray.length === 0">
                    <span class="font-class">{{isUploading === true?$t('components.appDataUploadView.importing')+"......":promptInfo}}</span>
                </template>
            </div>
        </el-row>
        <el-row>
            <!-- <el-col :span="4">
            <div class="import-temp">
                <div style="cursor: pointer;display: inline-block;" @click="downloadSuccessData">{{importSuccessData.length >0?"下载导入成功数据":""}}</div>
            </div>
            </el-col>
            <el-col :span="4">
                <div class="import-temp">
                    <span style="cursor: pointer;display: inline-block;" @click="downloadErrorData">{{importErrorData.length >0?"下载导入失败数据":""}}</span>
                </div>
            </el-col> -->
            <el-col :span="2" :offset="22">
                <el-button type="primary" @click="handleOK">{{$t('components.appDataUploadView.confirm')}}</el-button>
            </el-col>
        </el-row>
    </div>
</template>

<script lang="ts">
import XLSX from 'xlsx';
import CodeListService from "@service/app/codelist-service";
import EntityService from '@/service/entity-service';
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';

@Component({
})
export default class AppDataUploadView extends Vue {

     /**
     * 传入视图上下文
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    @Prop() protected viewdata!: string;

    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    @Prop() protected viewparam!: string;

    /**
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof AppDataUploadView
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @protected
     * @type {EntityService}
     * @memberof AppDataUploadView
     */
    protected entityService: EntityService = new EntityService();

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppDataUploadView
     */
    protected viewparams:any = {};

    /**
     * 导入数据模型
     *
     * @type {Array<*>}
     * @memberof AppDataUploadView
     */
    protected importDataModel:Array<any> = [];

    /**
     * 导入数据集合
     *
     * @type {Array<*>}
     * @memberof AppDataUploadView
     */
    protected importDataArray:Array<any> = [];

    /**
     * 导入标识
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    protected importId:string = "";

    /**
     * 是否已有导入数据
     *
     * @type {boolean}
     * @memberof AppDataUploadView
     */
    protected hasImported:boolean = false;

    /**
     * 导入数据识别项属性
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    protected importUniqueItem:string ="";

    /**
     * 提示信息
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    protected promptInfo:string ="";

    /**
     * 导入状态
     *
     * @type {boolean}
     * @memberof AppDataUploadView
     */
    protected isUploading:boolean = false;

    /**
     * 导入成功数据
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    protected importSuccessData:Array<any> = [];

    /**
     * 导入失败数据
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    protected importErrorData:Array<any> = [];

    /**
     * 读取完成的数据
     *
     * @type {*}
     * @memberof AppDataUploadView
     */
    public workBookData:any;

    /**
     * 所有的代码表
     *
     * @type {*}
     * @memberof AppDataUploadView
     */
    public allCodeList:any;

    /**
     * 属性Map(用作属性转化)
     *
     * @type {*}
     * @memberof AppDataUploadView
     */
    public allFieldMap:Map<string,any> = new Map();

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDataUploadView
     */
    @Watch('viewparam',{immediate: true, deep: true})
    onParamData(newVal: any, oldVal: any) {
        if(newVal){
            Object.assign(this.viewparams, JSON.parse(this.viewparam));
            this.initBasic();
        } 
    }

    /**
     * 初始化基础数据
     *
     * @memberof AppDataUploadView
     */
    public async initBasic(){
        if(this.viewparams.importId){
            this.importId = this.viewparams.importId;
        }
        if(this.viewparams.importData){
            this.importDataModel = Object.values(this.viewparams.importData);
            this.BubbleSort(this.importDataModel,this.importDataModel.length);
        }
        this.importDataModel.forEach((item:any) =>{
            if(item.isuniqueitem){
                this.importUniqueItem = item.headername;
            }
            this.allFieldMap.set(item.headername,item);
        });
        //获取代码表值
        this.allCodeList = await this.getChartAllCodeList();
    }

    /**
     * 冒泡排序
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDataUploadView
     */
    public BubbleSort(array:Array<any>,length:number){
        for (let i = 0; i < length; i++){
		for (let j = 0; j < length -  i - 1; j++){
                if (array[j].order > array[j + 1].order){
                    let temp:any;
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 下载导入数据模板
     *
     * @memberof AppDataUploadView
     */
    public downloadTemp(){
        this.importExcel(this.viewparams.appDeLogicName+this.$t('components.appDataUploadView.datatemp'),[]);
    }

    /**
     * 选择文件
     *
     * @memberof AppDataUploadView
     */
    public handleUpLoad(){
        this.importSuccessData = [];
        (this.$refs.inputUpLoad as any).click();
    }

    /**
     * 上传服务器
     *
     * @memberof AppDataUploadView
     */
    public uploadServer(){
        if(this.importDataArray.length == 0){
            return;
        }
        let tempDataArray:Array<any> = [];
        this.transformData(this.importDataArray,tempDataArray);
        this.hasImported = true;
        this.isUploading = true;
        this.importDataArray = [];
        try{
            this.entityService.getService(this.viewparams.serviceName).then((service:any) =>{
            service.ImportData(this.viewdata,{name:this.importId,data:tempDataArray}).then((res:any) =>{
                const result:any = res.data;
                if(result && result.rst !== 0){
                    this.promptInfo = (this.$t('components.appDataUploadView.importfailed') as string);
                    this.isUploading = false;
                    return;
                }
                this.importSuccessData = result.data;
                this.promptInfo = (this.$t('components.appDataUploadView.completed') as string);
                this.isUploading = false;
            })
            }).catch((error:any) =>{
                this.isUploading = false;
                this.promptInfo = (this.$t('components.appDataUploadView.importfailed') as string);
                console.error(error);
            })
        }catch(error){
            this.isUploading = false;
            this.promptInfo = (this.$t('components.appDataUploadView.importfailed') as string);
            console.error(error);
        };
    }

    /**
     * 导出excel
     *
     * @memberof AppDataUploadView
     */
    public async importExcel (filename:string,_data:any){
        const tHeader: Array<any> = [];
        this.importDataModel.forEach((item: any) => {
            tHeader.push(item.headername);
        });
        //const data = await this.formatExcelData(filterVal, _data);
        const data = _data?_data:[];
        this.$export.exportExcel().then((excel:any)=>{
            excel.export_json_to_excel({
                header: tHeader, //表头 必填
                data:data, //具体数据 必填
                filename: filename, //非必填
                autoWidth: true, //非必填
                bookType: "xlsx" //非必填
            });
        }); 
    };

    /**
     * 确认
     *
     * @memberof AppDataUploadView
     */
    public handleOK(){
        this.$emit('close',this.importSuccessData);
    }

    /**
     * 导入Excel
     *
     * @memberof AppDataUploadView
     */
    public importFile($event:any) {
        let obj = $event.target || $event.srcElement;
       if (!obj.files) {
           return;
       }
       let f = obj.files[0];
       let reader = new FileReader();
       reader.onload = (e:any) => {
           let data = e.target.result;
           this.workBookData = XLSX.read(data, {type: 'binary'});
           let xlsxData = XLSX.utils.sheet_to_json(this.workBookData.Sheets[this.workBookData.SheetNames[0]]);
           let list1 = this.getFirstRow(this.workBookData);
           xlsxData = this.AddXlsxData(xlsxData, list1);
           this.importDataArray = JSON.parse(JSON.stringify(xlsxData));
           (this.$refs.inputUpLoad as any).value = '';
       };
       reader.readAsBinaryString(f);
   }

    /**
     * 获取excel第一行的内容
     *
     * @memberof AppDataUploadView
     */
   public getFirstRow(wb:any) {
       //// 读取的excel单元格内容
       let wbData = wb.Sheets[wb.SheetNames[0]];
       // 匹配excel第一行的内容
       let re = /^[A-Z]1$/; 
       let temparr = [];
       // excel第一行内容赋值给数组
       for (let key in wbData) {
           if (wbData.hasOwnProperty(key)) {
               if (re.test(key)) {
                   temparr.push(wbData[key].h);
               }
           }
       }
       return temparr;
   }

    /**
     * 增加对应字段空白内容
     *
     * @memberof AppDataUploadView
     */
   public AddXlsxData(xlsxData:any, list1:any) {
       // 空白字段替换值
       let addData = null;
       for (let i = 0; i < xlsxData.length; i++) {
           // 要被JSON的数组
           for (let j = 0; j < list1.length; j++) {
               // excel第一行内容
               if (!xlsxData[i][list1[j]]) {
                   xlsxData[i][list1[j]] = addData;
               }
           }
       }
       return xlsxData;
   }

    /**
     * 获取图表所需代码表
     * 
     * @memberof AppDataUploadView
     */
    public async getChartAllCodeList(){
        let codeListMap:Map<string,any> = new Map();
        if(Object.values(this.importDataModel).length >0){
            await Object.values(this.importDataModel).forEach(async (singleDataModel:any) =>{
                if(singleDataModel.codelist){
                    let tempCodeListMap:Map<any,any> = new Map();
                    let res:any = await this.getCodeList(singleDataModel.codelist);
                    if(res && res.length >0){
                        res.forEach((codeListItem:any) =>{
                            tempCodeListMap.set(codeListItem.value,codeListItem.text);
                        })
                    }
                    codeListMap.set(singleDataModel.codelist.tag,tempCodeListMap);
                }
            })
        }
        return codeListMap;
    }

    /**
     * 获取代码表
     * 
     * @returns {Promise<any>} 
     * @memberof AppDataUploadView
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

    /**
     * 转化数据
     * 
     * @memberof AppDataUploadView
     */
    public transformData(data:Array<any>,result:Array<any>){
        data.forEach((item:any) =>{
            let curObject:any = {};
            Object.keys(item).forEach((ele:any) => {
                if(this.allFieldMap.get(ele).codelist){
                    let codelistTag:string = this.allFieldMap.get(ele).codelist.tag;
                     let codelistIsNumber:boolean = this.allFieldMap.get(ele).codelist.isnumber;
                    let curCodeList:any = this.transCodeList(codelistTag,codelistIsNumber,true);
                   Object.defineProperty(curObject, this.allFieldMap.get(ele).name, {
                        value: curCodeList.get(item[ele]),
                        writable : true,
                        enumerable : true,
                        configurable : true
                    }); 
                }else{
                    Object.defineProperty(curObject, this.allFieldMap.get(ele).name, {
                        value: item[ele],
                        writable : true,
                        enumerable : true,
                        configurable : true
                    }); 
                }
            });
            result.push(curObject);
        })
    }

    /**
     * 翻译代码表
     * 
     * @memberof AppDataUploadView
     */
    public transCodeList(codeListTag:string,codelistIsNumber:boolean,isTransform:boolean){
        let curCodeList:any = this.allCodeList.get(codeListTag);
        if(isTransform){
            let tempCodelist:Map<string,string> = new Map();
            curCodeList.forEach((item:string,key:string) =>{
                let value:any = codelistIsNumber?Number(key):key;
                tempCodelist.set(item,value);
            })
            curCodeList = tempCodelist;
        }
        return curCodeList;
    }

}
</script>

<style lang='less'>
@import './app-data-upload.less';
</style>