<template>
<div class='grid' style="height:100%;">
        <el-table v-if="isDisplay === true"
        :default-sort="{ prop: minorSortPSDEF, order: Object.is(minorSortDir, 'ASC') ? 'ascending' : Object.is(minorSortDir, 'DESC') ? 'descending' : '' }"  
        @sort-change="onSortChange($event)"  
        :border="isDragendCol"
        :height="isEnablePagingBar && items.length > 0 ? 'calc(100% - 36px)' : '100%'"  
        :highlight-current-row ="isSingleSelect"
        :row-class-name="getRowClassName"
        @row-click="rowClick($event)"  
        @select-all="selectAll($event)"  
        @select="select($event)"  
        @row-class-name="onRowClassName($event)"  
        @row-dblclick="rowDBLClick($event)"  
        ref='multipleTable' :data="items" :show-header="!isHideHeader">
            <template v-if="!isSingleSelect">
                <el-table-column align="center" type='selection' :width="checkboxColWidth"></el-table-column>
            </template>
            <template v-if="getColumnState('ygbh')">
                <el-table-column show-overflow-tooltip :prop="'ygbh'" :label="$t('entities.pimcontract.main_2_grid.columns.ygbh')" :width="120" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.ygbh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pimpersonname')">
                <el-table-column show-overflow-tooltip :prop="'pimpersonname'" :label="$t('entities.pimcontract.main_2_grid.columns.pimpersonname')" :width="120" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <app-column-link deKeyField='pimperson' :context="JSON.parse(JSON.stringify(context))" :viewparams="JSON.parse(JSON.stringify(viewparams))" :data="row" :linkview="{viewname: 'pimpersonedit-view2', height: 0,width: 0,title: $t('entities.pimperson.views.editview2.title'),placement: 'DRAWER_TOP', isRedirectView: false,deResParameters: [
            ]
            ,parameters: [
            { pathName: 'pimpeople', parameterName: 'pimperson' },
            { pathName: 'editview2', parameterName: 'editview2' }
            ]}" valueitem="pimpersonid">
                            <span>{{row.pimpersonname}}</span>
                        </app-column-link >
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zzdzs')">
                <el-table-column show-overflow-tooltip :prop="'zzdzs'" :label="$t('entities.pimcontract.main_2_grid.columns.zzdzs')" :width="140" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.zzdzs}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ygzt')">
                <el-table-column show-overflow-tooltip :prop="'ygzt'" :label="$t('entities.pimcontract.main_2_grid.columns.ygzt')" :width="120" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.ygzt" tag='PIMCL_YGZT' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('dbdwsj')">
                <el-table-column show-overflow-tooltip :prop="'dbdwsj'" :label="$t('entities.pimcontract.main_2_grid.columns.dbdwsj')" :width="140" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.dbdwsj}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('htbh')">
                <el-table-column show-overflow-tooltip :prop="'htbh'" :label="$t('entities.pimcontract.main_2_grid.columns.htbh')" :width="120" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.htbh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pimlabourcampanyname')">
                <el-table-column show-overflow-tooltip :prop="'pimlabourcampanyname'" :label="$t('entities.pimcontract.main_2_grid.columns.pimlabourcampanyname')" :width="160" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <app-column-link deKeyField='pimlabourcampany' :context="JSON.parse(JSON.stringify(context))" :viewparams="JSON.parse(JSON.stringify(viewparams))" :data="row" :linkview="{viewname: 'pimlabourcampanyredirect-view', height: 0,width: 0,title: $t('entities.pimlabourcampany.views.redirectview.title'),placement: '', isRedirectView: true,deResParameters: [
            ]
            ,parameters: [
            { pathName: 'pimlabourcampanies', parameterName: 'pimlabourcampany' },
            { pathName: 'redirectview', parameterName: 'redirectview' }
            ]}" valueitem="pimlabourcampanyid">
                            <span>{{row.pimlabourcampanyname}}</span>
                        </app-column-link >
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('htlx')">
                <el-table-column show-overflow-tooltip :prop="'htlx'" :label="$t('entities.pimcontract.main_2_grid.columns.htlx')" :width="120" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.htlx" tag='PIMCL_HTLX' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('contracttype')">
                <el-table-column show-overflow-tooltip :prop="'contracttype'" :label="$t('entities.pimcontract.main_2_grid.columns.contracttype')" :width="120" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.contracttype" tag='PIMCL_TYPECONTRACT' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('qsrq')">
                <el-table-column show-overflow-tooltip :prop="'qsrq'" :label="$t('entities.pimcontract.main_2_grid.columns.qsrq')" :width="120" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <app-format-data format="YYYY-MM-DD" :data="row.qsrq"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('jsrq')">
                <el-table-column show-overflow-tooltip :prop="'jsrq'" :label="$t('entities.pimcontract.main_2_grid.columns.jsrq')" :width="120" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <app-format-data format="YYYY-MM-DD" :data="row.jsrq"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('htsyts')">
                <el-table-column show-overflow-tooltip :prop="'htsyts'" :label="$t('entities.pimcontract.main_2_grid.columns.htsyts')" :width="140" :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.htsyts}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="adaptiveState">
                <el-table-column></el-table-column>
            </template>
    </el-table>
    <row class='grid-pagination' v-show="items.length > 0">
        <page class='pull-right' @on-change="pageOnChange($event)" 
            @on-page-size-change="onPageSizeChange($event)"
            :transfer="true" :total="totalrow"
            show-sizer :current="curPage" :page-size="limit"
            :page-size-opts="[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]" show-elevator show-total>
            <span>
                <span class="page-column">
                    <poptip transfer placement="top-start">
                        <i-button icon="md-menu">{{$t('app.gridpage.choicecolumns')}}</i-button>
                        <div slot="content">
                            <template v-for="col in allColumns">
                                <div :key="col.name"><el-checkbox v-model="col.show" @change="onColChange()">{{$t(col.langtag)}}</el-checkbox></div>
                            </template>
                        </div>
                    </poptip>
                </span>
                <span class="page-button"><i-button icon="md-refresh" :title="$t('app.gridpage.refresh')" @click="pageRefresh()"></i-button></span>&nbsp;
                <span>
                    {{$t('app.gridpage.show')}}&nbsp;
                    <span>
                        <template v-if="items.length === 1">
                        1
                        </template>
                        <template v-else>
                            <span>{{(curPage - 1) * limit + 1}}&nbsp;-&nbsp;{{totalrow > curPage * limit ? curPage * limit : totalrow}}</span>
                        </template>
                    </span>&nbsp;
                    {{$t('app.gridpage.records')}}，{{$t('app.gridpage.totle')}}&nbsp;{{totalrow}}&nbsp;{{$t('app.gridpage.records')}}
                </span>
            </span>
        </page>
    </row>
</div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PIMCONTRACTService from '@/service/pimcontract/pimcontract-service';
import Main_2Service from './main-2-grid-service';

import CodeListService from "@service/app/codelist-service";


@Component({
    components: {
      
    }
})
export default class Main_2Base extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof Main_2
     */
    @Prop() protected name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof Main_2
     */
    @Prop() protected viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof Main_2
     */
    @Prop() protected context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof Main_2
     */
    @Prop() protected viewparams: any;

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof Main_2
     */
    protected viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof Main_2
     */
    protected getControlType(): string {
        return 'GRID'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof Main_2
     */    
    protected counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {Main_2Service}
     * @memberof Main_2
     */
    protected service: Main_2Service = new Main_2Service({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PIMCONTRACTService}
     * @memberof Main_2
     */
    protected appEntityService: PIMCONTRACTService = new PIMCONTRACTService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof Main_2
     */
    protected closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof Main_2
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
     * 代码表服务对象
     *
     * @type {CodeListService}
     * @memberof Main_2
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof Main_2
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof Main_2
     */
    public getData(): any {
        return this.selections[0];
    }

    /**
     * 打开新建数据视图
     *
     * @type {any}
     * @memberof Main_2
     */
    @Prop() protected newdata: any;
    /**
     * 打开编辑数据视图
     *
     * @type {any}
     * @memberof Main_2
     */
    @Prop() protected opendata: any;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof Main_2
     */
    @Prop({ default: true }) protected showBusyIndicator?: boolean;

    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof Main_2
     */
    @Prop() protected updateAction!: string;
    
    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof Main_2
     */
    @Prop() protected fetchAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof Main_2
     */
    @Prop() protected removeAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof Main_2
     */
    @Prop() protected loadAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof Main_2
     */
    @Prop() protected loaddraftAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main_2
     */
    @Prop() protected createAction!: string;

    /**
     * 当前页
     *
     * @type {number}
     * @memberof Main_2
     */
    protected curPage: number = 1;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof Main_2
     */
    protected items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof Main_2
     */
    protected isEnablePagingBar: boolean = true;

    /**
     * 是否禁用排序
     *
     * @type {boolean}
     * @memberof Main_2
     */
    protected isNoSort: boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof Main_2
     */
    protected minorSortDir: string = 'ASC';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof Main_2
     */
    protected minorSortPSDEF: string = 'ygbh';

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof Main_2
     */
    protected limit: number = 100;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof Main_2
     */
    protected isHideHeader: boolean = false;

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof Main_2
     */
    @Prop({ default: false }) protected isSelectFirstDefault!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof Main_2
     */
    @Prop() protected isSingleSelect?: boolean;

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof Main_2
     */
    @Prop() protected selectedData?: string;

    /**
     * 选中值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainTree
     */
    @Watch('selectedData')
    public onValueChange(newVal: any, oldVal: any) {
        this.selections = [];
        if(this.selectedData){
            const refs: any = this.$refs;
            if (refs.multipleTable) {
                refs.multipleTable.clearSelection();
                JSON.parse(this.selectedData).forEach((selection:any)=>{
                    let selectedItem = this.items.find((item:any)=>{
                        return Object.is(item.srfkey, selection.srfkey);
                    });
                    if(selectedItem){
                        this.rowClick(selectedItem);
                    }
                });
            }
        }
    }

    /**
     * 表格行数据默认激活模式
     * 0 不激活
     * 1 单击激活
     * 2 双击激活
     *
     * @type {(number | 0 | 1 | 2)}
     * @memberof Main_2
     */
    @Prop({default: 2}) protected gridRowActiveMode!: number;

    /**
     * 是否开启行编辑
     *
     * @type {boolean}
     * @memberof Main_2
     */
    @Prop({default: false}) protected isOpenEdit!: boolean;

    /**
     * 实际是否开启行编辑
     *
     * @type {boolean}
     * @memberof Main_2
     */
    protected actualIsOpenEdit: boolean = this.isOpenEdit;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof Main_2
     */
    protected totalrow: number = 0;

    /**
     * 选中行数据
     *
     * @type {any[]}
     * @memberof Main
     */
    protected selections: any[] = [];

    /**
     * 拦截行选中
     *
     * @type {boolean}
     * @memberof Main
     */
    protected stopRowClick: boolean = false;


    /**
     * 表格是否显示
     *
     * @type {boolean}
     * @memberof Main_2
     */
    protected isDisplay:boolean = true;

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof Main_2
     */
    protected refresh(args: any[]): void {
        this.load();
    }

    /**
    * 选项框列宽
    *
    * @type {number}
    * @memberof AppIndex
    */
    protected checkboxColWidth: number = 34;

    /**
     * 是否允许拖动列宽
     *
     * @type {boolean}
     * @memberof AppEmbedPicker
     */
    protected isDragendCol: boolean = false;

    /**
     * 所有列成员
     *
     * @type {any[]}
     * @memberof Main_2
     */
    protected allColumns: any[] = [
        {
            name: 'ygbh',
            label: '员工编号',
            langtag: 'entities.pimcontract.main_2_grid.columns.ygbh',
            show: true,
            util: 'px'
        },
        {
            name: 'pimpersonname',
            label: '员工姓名',
            langtag: 'entities.pimcontract.main_2_grid.columns.pimpersonname',
            show: true,
            util: 'px'
        },
        {
            name: 'zzdzs',
            label: '员工所属单位',
            langtag: 'entities.pimcontract.main_2_grid.columns.zzdzs',
            show: true,
            util: 'PX'
        },
        {
            name: 'ygzt',
            label: '员工状态',
            langtag: 'entities.pimcontract.main_2_grid.columns.ygzt',
            show: true,
            util: 'PX'
        },
        {
            name: 'dbdwsj',
            label: '到本单位时间',
            langtag: 'entities.pimcontract.main_2_grid.columns.dbdwsj',
            show: true,
            util: 'PX'
        },
        {
            name: 'htbh',
            label: '合同编号',
            langtag: 'entities.pimcontract.main_2_grid.columns.htbh',
            show: true,
            util: 'px'
        },
        {
            name: 'pimlabourcampanyname',
            label: '所属劳务派遣公司',
            langtag: 'entities.pimcontract.main_2_grid.columns.pimlabourcampanyname',
            show: true,
            util: 'PX'
        },
        {
            name: 'htlx',
            label: '合同类别',
            langtag: 'entities.pimcontract.main_2_grid.columns.htlx',
            show: true,
            util: 'px'
        },
        {
            name: 'contracttype',
            label: '合同类型',
            langtag: 'entities.pimcontract.main_2_grid.columns.contracttype',
            show: true,
            util: 'PX'
        },
        {
            name: 'qsrq',
            label: '起始日期',
            langtag: 'entities.pimcontract.main_2_grid.columns.qsrq',
            show: true,
            util: 'px'
        },
        {
            name: 'jsrq',
            label: '结束日期',
            langtag: 'entities.pimcontract.main_2_grid.columns.jsrq',
            show: true,
            util: 'px'
        },
        {
            name: 'htsyts',
            label: '合同剩余天数',
            langtag: 'entities.pimcontract.main_2_grid.columns.htsyts',
            show: true,
            util: 'px'
        },
    ]

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof Main_2
     */
    protected rules: any = {
        srfkey: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '合同信息标识 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '合同信息标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 表格数据加载
     *
     * @param {*} [arg={}]
     * @memberof Main_2
     */
    protected load(opt: any = {}, pageReset: boolean = false): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PIMCONTRACTLWGridView视图表格fetchAction参数未配置' });
            return;
        }
        if(pageReset){
            this.curPage = 1;
        }
        const arg: any = {...opt};
        const page: any = {};
        if (this.isEnablePagingBar) {
            Object.assign(page, { page: this.curPage-1, size: this.limit });
        }
        // 设置排序
        if (!this.isNoSort && !Object.is(this.minorSortDir, '') && !Object.is(this.minorSortPSDEF, '')) {
            const sort: string = this.minorSortPSDEF+","+this.minorSortDir;
            Object.assign(page, { sort: sort });
        }
        Object.assign(arg, page);
        const parentdata: any = {};
        this.$emit('beforeload', parentdata);
        Object.assign(arg, parentdata);
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.search(this.fetchAction,JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.errorMessage) {
                    this.$Notice.error({ title: '错误', desc: response.errorMessage });
                }
                return;
            }
            const data: any = response.data;
            this.totalrow = response.total;
            this.items = JSON.parse(JSON.stringify(data));
            // 清空selections
            this.selections = [];
            this.$emit('load', this.items);
            // 设置默认选中
            let _this = this;
            setTimeout(() => {
                if(_this.isSelectFirstDefault){
                  _this.rowClick(_this.items[0]);
                }
                if(_this.selectedData){
                    const refs: any = _this.$refs;
                    if (refs.multipleTable) {
                        refs.multipleTable.clearSelection();
                        JSON.parse(_this.selectedData).forEach((selection:any)=>{
                            let selectedItem = _this.items.find((item:any)=>{
                                return Object.is(item.srfkey, selection.srfkey);
                            });
                            if(selectedItem){
                                _this.rowClick(selectedItem);
                            }
                        });
                    }
                }
            }, 300);
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            this.$Notice.error({ title: '错误', desc: response.errorMessage });
        });
    }

    /**
     * 删除
     *
     * @param {any[]} datas
     * @returns {Promise<any>}
     * @memberof Main_2
     */
    protected async remove(datas: any[]): Promise<any> {
        if(!this.removeAction){
            this.$Notice.error({ title: '错误', desc: 'PIMCONTRACTLWGridView视图表格removeAction参数未配置' });
            return;
        }
        let _datas:any[] = [];
        datas.forEach((record: any, index: number) => {
            if (!record.srfkey) {
                this.items.some((val: any, num: number) =>{
                    if(JSON.stringify(val) == JSON.stringify(record)){
                        this.items.splice(num,1);
                        return true;
                    }
                }); 
            }else{
               _datas.push(datas[index]);
            }
        });
        if (_datas.length === 0) {
            return;
        }
        let dataInfo = '';
        _datas.forEach((record: any, index: number) => {
            let srfmajortext = record.pimpersonname;
            if (index < 5) {
                if (!Object.is(dataInfo, '')) {
                    dataInfo += '、';
                }
                dataInfo += srfmajortext;
            } else {
                return false;
            }
        });

        if (_datas.length < 5) {
            dataInfo = dataInfo + ' 共' + _datas.length + '条数据';
        } else {
            dataInfo = dataInfo + '...' + ' 共' + _datas.length + '条数据';
        }

        const removeData = () => {
            let keys: any[] = [];
            _datas.forEach((data: any) => {
                keys.push(data.srfkey);
            });
            let _removeAction = keys.length > 1 ? 'removeBatch' : this.removeAction ;
            const context:any = JSON.parse(JSON.stringify(this.context));
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ pimcontract: keys.join(';') }),Object.assign({ pimcontract: keys.join(';') },{viewparams:this.viewparams}), this.showBusyIndicator);
            return new Promise((resolve: any, reject: any) => {
                post.then((response: any) => {
                    if (!response || response.status !== 200) {
                        this.$Notice.error({ title: '', desc: '删除数据失败,' + response.info });
                        return;
                    } else {
                        this.$Notice.success({ title: '', desc: '删除成功!' });
                    }
                    //删除items中已删除的项
                    console.log(this.items);
                    _datas.forEach((data: any) => {
                      this.items.some((item:any,index:number)=>{
                        if(Object.is(item.srfkey,data.srfkey)){
                          this.items.splice(index,1);
                                return true;
                            }
                        });
                    });
                    this.totalrow -= _datas.length;
                    this.$emit('remove', null);
                    this.selections = [];
                    resolve(response);
                }).catch((response: any) => {
                    if (response && response.status === 401) {
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
                        reject(response);
                        return;
                    }
                    reject(response);
                });
            });
        }

        dataInfo = dataInfo.replace(/[null]/g, '').replace(/[undefined]/g, '');
        this.$Modal.confirm({
            title: '警告',
            content: '确认要删除 ' + dataInfo + '，删除操作将不可恢复？',
            onOk: () => {
                removeData();
            },
            onCancel: () => { }
        });
        return removeData;
    }


    /**
     * 批量添加
     *
     * @param {*} [arg={}]
     * @memberof Main_2
     */
    protected addBatch(arg: any = {}): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PIMCONTRACTLWGridView视图表格fetchAction参数未配置' });
            return;
        }
        if(!arg){
            arg = {};
        }
        console.error("批量添加未实现");
    }

    /**
     * 数据导入
     *
     * @param {*} data
     * @memberof Main_2
     */
     public importExcel(data:any ={}):void{
        //导入excel
        const importDataModel:any ={
        }
        if(Object.keys(importDataModel).length == 0){
            this.$Notice.warning({ 'title': (this.$t("app.utilview.warning") as string), 'desc': (this.$t("app.utilview.info") as string) });
            return;
        }
        const view:any ={
            viewname: 'app-data-upload',
            title: this.$t("app.utilview.importview"),
            width: 900,
            height: 700
        }
        let container: Subject<any> = this.$appmodal.openModal(view, JSON.parse(JSON.stringify(this.context)), importDataModel);
        container.subscribe((result: any) => {
          if(Object.is(result.ret,'OK')){
            this.refresh(result.datas);
          }
      });
    }


    /**
     * 数据导出
     *
     * @param {*} data
     * @memberof Main_2
     */
    protected exportExcel(data: any = {}): void {
        // 导出Excel
        const doExport = async (_data:any) => {
            const tHeader: Array<any> = [];
            const filterVal: Array<any> = [];
            this.allColumns.forEach((item: any) => {
              item.show && item.label ? tHeader.push(this.$t(item.langtag)) : "";
              item.show && item.name ? filterVal.push(item.name) : "";
            });
            const data = await this.formatExcelData(filterVal, _data);
            this.$export.exportExcel().then((excel:any)=>{
                excel.export_json_to_excel({
                  header: tHeader, //表头 必填
                  data, //具体数据 必填
                  filename: "合同信息表", //非必填
                  autoWidth: true, //非必填
                  bookType: "xlsx" //非必填
                });
            }); 
        };
        const page: any = {};
        // 设置page，size
        if (Object.is(data.type, 'maxRowCount')) {
            Object.assign(page, { page: 0, size: data.maxRowCount });
        } else if (Object.is(data.type, 'activatedPage')) {
            try {
                doExport(JSON.parse(JSON.stringify(this.items)));
            } catch (error) {
                console.error(error);
            }
            return;
        }
        // 设置排序
        if (!this.isNoSort && !Object.is(this.minorSortDir, '') && !Object.is(this.minorSortPSDEF, '')) {
          const sort: string = this.minorSortPSDEF+","+this.minorSortDir;
            Object.assign(page, { sort: sort });
        }
        const arg: any = {};
        Object.assign(arg, page);
        // 获取query,搜索表单，viewparams等父数据
        const parentdata: any = {};
        this.$emit('beforeload', parentdata);
        Object.assign(arg, parentdata);
        const post: Promise<any> = this.service.search(this.fetchAction,JSON.parse(JSON.stringify(this.context)), arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: '', desc: '数据导出失败,' + response.info });
                return;
            }
            try {
                doExport(JSON.parse(JSON.stringify(response.data)));
            } catch (error) {
                console.error(error);
            }
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            this.$Notice.error({ title: '', desc: '数据导出失败' });
        });
    }


    /**
     * 导出数据格式化
     * 
     * @param {*} filterVal
     * @param {*} jsonData
     * @returns {[]}
     * @memberof Main_2
     */
    public async formatExcelData(filterVal:any, jsonData:any) {
        let codelistColumns:Array<any> = [
          {
            name: 'ygzt',
            srfkey: 'PIMCL_YGZT',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ';',
          },
          {
            name: 'htlx',
            srfkey: 'PIMCL_HTLX',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'contracttype',
            srfkey: 'PIMCL_TYPECONTRACT',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ';',
          },
        ];
        let _this = this;
        for (const codelist of codelistColumns) {
          // 动态代码表处理
          if (Object.is(codelist.codelistType, "DYNAMIC")) {
              let items = await _this.codeListService.getItems(codelist.srfkey);
              jsonData.forEach((row:any)=>{
                  row[codelist.name] = _this.getCodelistValue(items, row[codelist.name], codelist);
              });
          // 静态处理
          } else if(Object.is(codelist.codelistType, "STATIC")){
              let items = await _this.$store.getters.getCodeListItems(codelist.srfkey);
              jsonData.forEach((row:any)=>{
                  row[codelist.name] = _this.getCodelistValue(items, row[codelist.name], codelist);
              });
          }
        }
        return jsonData.map((v:any) => filterVal.map((j:any) => v[j]))
    }   


    /**
     * 解析代码表和vlaue，设置items
     *
     * @private
     * @param {any[]} items 代码表数据
     * @param {*} value
     * @returns {*}
     * @memberof Main_2
     */
    private getCodelistValue(items: any[], value: any, codelist: any,){
        if(!value){
            return this.$t('codelist.'+codelist.srfkey+'.empty');
        }
        if (items) {
            let result:any = [];
            if(Object.is(codelist.renderMode,"number")){
                items.map((_item: any, index: number)=>{
                    const nValue = parseInt((value as any), 10);
                    const codevalue = _item.value;
                    if((parseInt(codevalue, 10) & nValue) > 0){
                        result.push(_item);
                    } 
                });
            } else if(Object.is(codelist.renderMode,"string")){
                const arrayValue: Array<any> = (value as any).split(codelist.valueSeparator);
                arrayValue.map((value: any, index: number) => {
                    result.push([]);
                    let values: any[] = Object.is(this.$util.typeOf(value), 'number') ? [value] : [...(value as any).split(codelist.valueSeparator)];
                    values.map((val:any ,num: number)=>{
                        const item = this.getItem(items, val, codelist); 
                        if(item){
                          result[index].push(item);
                        } 
                    });
                });
            } else {
                let values: any[] = Object.is(this.$util.typeOf(value), 'number') ? [value] : [...(value as any).split(codelist.valueSeparator)];
                values.map((value:any ,index: number)=>{
                    const item = this.getItem(items, value, codelist); 
                    if(item){
                      result.push(item);
                    } 
                });
            }
            // 设置items
            if(result.length != 0){
              return result.join(codelist.valueSeparator);
            }else{
              return value;
            }
        }
    }

    /**
     * 获取代码项
     *
     * @private
     * @param {any[]} items
     * @param {*} value
     * @returns {*}
     * @memberof Main_2
     */
    private getItem(items: any[], value: any, codelist: any): any {
        const arr: Array<any> = items.filter(item => {return item.value == value});
        if (arr.length !== 1) {
            return undefined;
        }
        if(Object.is(codelist.codelistType,'STATIC')){
            return this.$t('codelist.'+codelist.srfkey+'.'+arr[0].value);
        }else{
            return arr[0].text;
        }
    }

    /**
     * 生命周期
     *
     * @memberof Main_2
     */
    protected created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof Main_2
     */    
    protected afterCreated(){
        this.setColState();
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('load', action)) {
                    this.load(data);
                }
                if (Object.is('remove', action)) {
                    this.remove(data);
                }
                if (Object.is('save', action)) {
                    this.save(data);
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof Main_2
     */
    protected destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof Main_2
     */
    protected afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 获取选中行胡数据
     *
     * @returns {any[]}
     * @memberof Main_2
     */
    protected getSelection(): any[] {
        return this.selections;
    }

    /**
     * 行双击事件
     *
     * @param {*} $event
     * @returns {void}
     * @memberof Main_2
     */
    protected rowDBLClick($event: any): void {
        if (!$event || this.actualIsOpenEdit || Object.is(this.gridRowActiveMode,0)) {
            return;
        }
        this.selections = [];
        this.selections.push(JSON.parse(JSON.stringify($event)));

        const refs: any = this.$refs;
        if (refs.multipleTable) {
            refs.multipleTable.clearSelection();
            refs.multipleTable.toggleRowSelection($event);
        }

        this.$emit('rowdblclick', this.selections);
        this.$emit('selectionchange', this.selections);
    }

    /**
     * 复选框数据选中
     *
     * @param {*} $event
     * @returns {void}
     * @memberof  Main_2
     */
    protected select($event: any): void {
        if (!$event) {
            return;
        }
        this.selections = [];
        this.selections = [...JSON.parse(JSON.stringify($event))];
        this.$emit('selectionchange', this.selections);
    }

    /**
     * 复选框数据全部选中
     *
     * @param {*} $event
     * @memberof  Main_2
     */
    protected selectAll($event: any): void {
        if (!$event) {
            return;
        }
        this.selections = [];
        this.selections = [...JSON.parse(JSON.stringify($event))];
        this.$emit('selectionchange', this.selections);
    }

    
    /**
     * 行单击选中
     *
     * @param {*} $event
     * @returns {void}
     * @memberof Main_2
     */
    protected rowClick($event: any, ifAlways: boolean = false): void {
        if (!ifAlways && (!$event || this.actualIsOpenEdit)) {
            return;
        }
        if(this.stopRowClick) {
            this.stopRowClick = false;
            return;
        }
        if(this.isSingleSelect){
            this.selections = [];
        }
        // 已选中则删除，没选中则添加
        let selectIndex = this.selections.findIndex((item:any)=>{
            return Object.is(item.pimcontract,$event.pimcontract);
        });
        if (Object.is(selectIndex,-1)){
          this.selections.push(JSON.parse(JSON.stringify($event)));
        } else {
          this.selections.splice(selectIndex,1);
        }

        const refs: any = this.$refs;
        if (refs.multipleTable) {
            if(this.isSingleSelect){
                refs.multipleTable.clearSelection();
                refs.multipleTable.setCurrentRow($event);
            }else{
                refs.multipleTable.toggleRowSelection($event); 
            }
        }

        this.$emit('selectionchange', this.selections);
    }


    /**
     * 页面变化
     *
     * @param {*} $event
     * @returns {void}
     * @memberof Main_2
     */
    protected pageOnChange($event: any): void {
        if (!$event) {
            return;
        }
        if ($event === this.curPage) {
            return;
        }
        this.curPage = $event;
        this.load({});
    }

    /**
     * 分页条数变化
     *
     * @param {*} $event
     * @returns {void}
     * @memberof Main_2
     */
    protected onPageSizeChange($event: any): void {
        if (!$event) {
            return;
        }
        if ($event === this.limit) {
            return;
        }
        this.limit = $event;
        if (this.curPage === 1) {
            this.load({});
        }
    }

    /**
     * 分页刷新
     *
     * @memberof Main_2
     */
    protected pageRefresh(): void {
        this.load({});
    }

    /**
     * 排序变化
     *
     * @param {{ column: any, prop: any, order: any }} { column, prop, order }
     * @memberof Main_2
     */
    protected onSortChange({ column, prop, order }: { column: any, prop: any, order: any }): void {
        const dir = Object.is(order, 'ascending') ? 'asc' : Object.is(order, 'descending') ? 'desc' : '';
        if (Object.is(dir, this.minorSortDir) && Object.is(this.minorSortPSDEF, prop)) {
            return;
        }
        this.minorSortDir = dir;
        this.minorSortPSDEF = prop ? prop : '';
        this.load({});
    }

    /**
     * 表格行选中样式
     *
     * @param {{ row: any, rowIndex: any }} { row, rowIndex }
     * @returns {string}
     * @memberof Main_2
     */
    protected onRowClassName({ row, rowIndex }: { row: any, rowIndex: any }): string {
        const index = this.selections.findIndex((select: any) => Object.is(select.srfkey, row.srfkey));
        return index !== -1 ? 'grid-row-select' : '';
    }



    /**
     * 界面行为
     *
     * @param {*} row
     * @param {*} tag
     * @param {*} $event
     * @memberof Main_2
     */
	protected uiAction(row: any, tag: any, $event: any) {
        this.rowClick(row, true);
    }

    /**
     * 设置列状态
     *
     * @memberof Main_2
     */
    protected setColState() {
		const _data: any = localStorage.getItem('pimcontract_main_2_grid');
		if (_data) {
			let columns = JSON.parse(_data);
			columns.forEach((col: any) => {
				let column = this.allColumns.find((item) => Object.is(col.name, item.name));
				if (column) {
					Object.assign(column, col);
				}
			});
		}
    }

    /**
     * 列变化
     *
     * @memberof Main_2
     */
    protected onColChange() {
        localStorage.setItem('pimcontract_main_2_grid', JSON.stringify(this.allColumns));
    }

    /**
     * 获取列状态
     *
     * @param {string} name
     * @returns {boolean}
     * @memberof Main_2
     */
    protected getColumnState(name: string): boolean {
        let column = this.allColumns.find((col: any) =>
            Object.is(name, col.name)
        );
        return column.show ? true : false;
    }

    /**
     * 表格列是否自适应布局
     *
     * @readonly
     * @type {boolean}
     * @memberof Main_2
     */
    get adaptiveState(): boolean {
        return !this.allColumns.find((column: any) => column.show && Object.is(column.util, 'STAR'));
    }

    /**
     * 保存
     *
     * @param {*} $event
     * @returns {void}
     * @memberof Main_2
     */
    protected save(args: any[], params?: any, $event?: any, xData?: any): void {
        let _this = this;
        let promises:any = [];
        _this.items.forEach((item:any)=>{
            if(!item.rowDataState){
                return;
            } else if(Object.is(item.rowDataState, 'create')){
                if(!this.createAction){
                    this.$Notice.error({ title: '错误', desc: 'PIMCONTRACTLWGridView视图表格createAction参数未配置' });
                    return;
                }
                Object.assign(item,{viewparams:this.viewparams});
                promises.push(this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator));
            }else if(Object.is(item.rowDataState, 'update')){
                if(!this.updateAction){
                    this.$Notice.error({ title: '错误', desc: 'PIMCONTRACTLWGridView视图表格updateAction参数未配置' });
                    return;
                }
                Object.assign(item,{viewparams:this.viewparams});
                if(item.pimcontract){
                    Object.assign(this.context,{pimcontract:item.pimcontract})
                }
                promises.push(this.service.add(this.updateAction,JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator));
            }
        });
        Promise.all(promises).then((response: any) => {
            this.$emit('save', response);
            this.$Notice.success({ title: '', desc: '保存成功!' });
            this.refresh([]);
        }).catch((response: any) => {
            this.$Notice.error({ title: '错误', desc: '系统异常' });
        });
    }


    /**
     * 获取对应行class
     *
     * @param {*} $args row 行数据，rowIndex 行索引
     * @returns {void}
     * @memberof Main_2
     */
    protected getRowClassName(args:{row: any,rowIndex: number}){
        let isSelected = this.selections.some((item:any)=>{
            return Object.is(item.pimcontract,args.row.pimcontract);
        });
        return isSelected ? "grid-selected-row" : "";
    }
}
</script>

<style lang='less'>
@import './main-2-grid.less';
</style>