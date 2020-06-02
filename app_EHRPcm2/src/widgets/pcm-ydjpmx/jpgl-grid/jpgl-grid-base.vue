<template>
<div class='grid' style="height:100%;">
      <i-form style="height:100%">
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
            <template slot="empty">
                无数据 
                <span class="quick-toolbar">
                </span>
            </template>
            <template v-if="!isSingleSelect">
                <el-table-column align="center" type='selection' :width="checkboxColWidth"></el-table-column>
            </template>
            <template v-if="getColumnState('cz')">
                <el-table-column show-overflow-tooltip :prop="'cz'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.cz')" :width="100"  :align="'center'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.cz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.cz}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ygbh')">
                <el-table-column show-overflow-tooltip :prop="'ygbh'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.ygbh')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.ygbh')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.ygbh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pimpersonname')">
                <el-table-column show-overflow-tooltip :prop="'pimpersonname'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.pimpersonname')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.pimpersonname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.pimpersonname}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zzdzs')">
                <el-table-column show-overflow-tooltip :prop="'zzdzs'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.zzdzs')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.zzdzs')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.zzdzs}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('shortname')">
                <el-table-column show-overflow-tooltip :prop="'shortname'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.shortname')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.shortname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.shortname}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('yzw')">
                <el-table-column show-overflow-tooltip :prop="'yzw'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.yzw')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.yzw')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.yzw" tag='EhrCodeList0233' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ygw')">
                <el-table-column show-overflow-tooltip :prop="'ygw'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.ygw')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.ygw')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.ygw" tag='EhrCodeList0050' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('lxdh')">
                <el-table-column show-overflow-tooltip :prop="'lxdh'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.lxdh')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.lxdh')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.lxdh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('sxrq')">
                <el-table-column show-overflow-tooltip :prop="'sxrq'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.sxrq')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.sxrq')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" :value="row[column.property]" style="" @on-change="(val1, val2) => { row[column.property] = val1; gridEditItemChange(row, column.property, val1, $index)}"></date-picker>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
                                <app-span name='sxrq' editorType="DATEPICKER" :value="row.sxrq"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('reason')">
                <el-table-column show-overflow-tooltip :prop="'reason'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.reason')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.reason')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='EhrCodeList0165' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.reason" tag='EhrCodeList0165' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('sfhmd')">
                <el-table-column show-overflow-tooltip :prop="'sfhmd'" :label="$t('entities.pcmydjpmx.jpgl_grid.columns.sfhmd')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmydjpmx.jpgl_grid.columns.sfhmd')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" style="width: 100px;" tag='EhrCodeList0054' codelistType='STATIC' placeholder='请选择...' @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.sfhmd" tag='EhrCodeList0054' codelistType='STATIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
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
                <span v-if="selections.length > 0" class="batch-toolbar">
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
  </i-form>
</div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PcmYdjpmxService from '@/service/pcm-ydjpmx/pcm-ydjpmx-service';
import JPGLService from './jpgl-grid-service';

import CodeListService from "@service/app/codelist-service";
import { FormItemModel } from '@/model/form-detail';


@Component({
    components: {
      
    }
})
export default class JPGLBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof JPGL
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof JPGL
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof JPGL
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof JPGL
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof JPGL
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof JPGL
     */
    public getControlType(): string {
        return 'GRID'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof JPGL
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {JPGLService}
     * @memberof JPGL
     */
    public service: JPGLService = new JPGLService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PcmYdjpmxService}
     * @memberof JPGL
     */
    public appEntityService: PcmYdjpmxService = new PcmYdjpmxService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof JPGL
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof JPGL
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
     * @memberof JPGL
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof JPGL
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof JPGL
     */
    public getData(): any {
        return this.selections[0];
    }

    /**
     * 打开新建数据视图
     *
     * @type {any}
     * @memberof JPGL
     */
    @Prop() public newdata: any;
    /**
     * 打开编辑数据视图
     *
     * @type {any}
     * @memberof JPGL
     */
    @Prop() public opendata: any;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof JPGL
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof JPGL
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof JPGL
     */
    @Prop() public fetchAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof JPGL
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof JPGL
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof JPGL
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof JPGL
     */
    @Prop() public createAction!: string;

    /**
     * 当前页
     *
     * @type {number}
     * @memberof JPGL
     */
    public curPage: number = 1;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof JPGL
     */
    public items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof JPGL
     */
    public isEnablePagingBar: boolean = true;

    /**
     * 是否禁用排序
     *
     * @type {boolean}
     * @memberof JPGL
     */
    public isNoSort: boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof JPGL
     */
    public minorSortDir: string = 'DESC';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof JPGL
     */
    public minorSortPSDEF: string = 'updatedate';

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof JPGL
     */
    public limit: number = 20;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof JPGL
     */
    public isHideHeader: boolean = false;

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof JPGL
     */
    @Prop({ default: false }) public isSelectFirstDefault!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof JPGL
     */
    @Prop() public isSingleSelect?: boolean;

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof JPGL
     */
    @Prop() public selectedData?: string;

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
     * @memberof JPGL
     */
    @Prop({default: 2}) public gridRowActiveMode!: number;

    /**
     * 是否开启行编辑
     *
     * @type {boolean}
     * @memberof JPGL
     */
    @Prop({default: false}) public isOpenEdit!: boolean;

    /**
     * 实际是否开启行编辑
     *
     * @type {boolean}
     * @memberof JPGL
     */
    public actualIsOpenEdit: boolean = this.isOpenEdit;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof JPGL
     */
    public totalrow: number = 0;

    /**
     * 选中行数据
     *
     * @type {any[]}
     * @memberof Main
     */
    public selections: any[] = [];

    /**
     * 拦截行选中
     *
     * @type {boolean}
     * @memberof Main
     */
    public stopRowClick: boolean = false;




    /**
     * 表格是否显示
     *
     * @type {boolean}
     * @memberof JPGL
     */
    public isDisplay:boolean = true;

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof JPGL
     */
    public refresh(args: any[]): void {
        this.load();
    }

    /**
    * 选项框列宽
    *
    * @type {number}
    * @memberof AppIndex
    */
    public checkboxColWidth: number = 34;

    /**
     * 是否允许拖动列宽
     *
     * @type {boolean}
     * @memberof AppEmbedPicker
     */
    public isDragendCol: boolean = false;

    /**
     * 所有列成员
     *
     * @type {any[]}
     * @memberof JPGL
     */
    public allColumns: any[] = [
        {
            name: 'cz',
            label: '操作',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.cz',
            show: true,
            util: 'PX'
        },
        {
            name: 'ygbh',
            label: '员工编号',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.ygbh',
            show: true,
            util: 'px'
        },
        {
            name: 'pimpersonname',
            label: '员工姓名',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.pimpersonname',
            show: true,
            util: 'px'
        },
        {
            name: 'zzdzs',
            label: '所属组织',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.zzdzs',
            show: true,
            util: 'px'
        },
        {
            name: 'shortname',
            label: '所属部门',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.shortname',
            show: true,
            util: 'px'
        },
        {
            name: 'yzw',
            label: '所属职务',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.yzw',
            show: true,
            util: 'px'
        },
        {
            name: 'ygw',
            label: '所属岗位',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.ygw',
            show: true,
            util: 'px'
        },
        {
            name: 'lxdh',
            label: '联系电话',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.lxdh',
            show: true,
            util: 'px'
        },
        {
            name: 'sxrq',
            label: '解聘日期',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.sxrq',
            show: true,
            util: 'PX'
        },
        {
            name: 'reason',
            label: '解聘原因',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.reason',
            show: true,
            util: 'PX'
        },
        {
            name: 'sfhmd',
            label: '是否加黑名单',
            langtag: 'entities.pcmydjpmx.jpgl_grid.columns.sfhmd',
            show: true,
            util: 'PX'
        },
    ]

    /**
     * 表格模型集合
     *
     * @type {*}
     * @memberof JPGL
     */
    public gridItemsModel: any[] = [];

    /**
     * 获取表格行模型
     *
     * @type {*}
     * @memberof JPGL
     */
    public getGridRowModel(){
        return {
          sfhmd: new FormItemModel(),
          reason: new FormItemModel(),
          srfkey: new FormItemModel(),
          sxrq: new FormItemModel(),
        }
    }

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof JPGL
     */
    public rules: any = {
        sfhmd: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '是否加黑名单 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '是否加黑名单 值不能为空', trigger: 'blur' },
        ],
        reason: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '解聘原因 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '解聘原因 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '异动解聘明细标识 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '异动解聘明细标识 值不能为空', trigger: 'blur' },
        ],
        sxrq: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '解聘日期 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '解聘日期 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 表格行编辑项校验
     *
     * @param {string} property 属性名
     * @param {*} data 行数据
     * @param {number} rowIndex 行索引
     * @returns Promise<any>
     * 
     * @memberof JPGL
     */
    public validate(property:string, data:any, rowIndex:number):Promise<any>{
        return new Promise((resolve, reject) => {
            this.$util.validateItem(property,data,this.rules).then(()=>{
                this.gridItemsModel[rowIndex][property].setError(null);
                resolve(true);
            }).catch(({ errors, fields }) => {
                this.gridItemsModel[rowIndex][property].setError(errors[0].message);
                resolve(false);
            });
        });
    }

    /**
     * 校验所有修改过的编辑项
     *
     * @returns Promise<any>
     * @memberof JPGL
     */
    public async validateAll(){
        let validateState = true;
        let index = -1;
        for(let item of this.items){
          index++;
          if(item.rowDataState === "create" || item.rowDataState === "update"){
            for(let property of Object.keys(this.rules)){
              if(!await this.validate(property,item,index)){
                validateState = false;
              }
            }
          }
        }
        return validateState;
    }

    /**
     * 表格数据加载
     *
     * @param {*} [arg={}]
     * @memberof JPGL
     */
    public load(opt: any = {}, pageReset: boolean = false): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PcmYdjpmxGLGridView视图表格fetchAction参数未配置' });
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
        let tempViewParams:any = parentdata.viewparams?parentdata.viewparams:{};
        Object.assign(tempViewParams,JSON.parse(JSON.stringify(this.viewparams)));
        Object.assign(arg,{viewparams:tempViewParams});
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
            // 清空selections,gridItemsModel
            this.selections = [];
            this.gridItemsModel = [];
            this.items.forEach(()=>{this.gridItemsModel.push(this.getGridRowModel())});
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
     * @memberof JPGL
     */
    public async remove(datas: any[]): Promise<any> {
        if(!this.removeAction){
            this.$Notice.error({ title: '错误', desc: 'PcmYdjpmxGLGridView视图表格removeAction参数未配置' });
            return;
        }
        let _datas:any[] = [];
        datas.forEach((record: any, index: number) => {
            if (!record.srfkey) {
                this.items.some((val: any, num: number) =>{
                    if(JSON.stringify(val) == JSON.stringify(record)){
                        this.items.splice(num,1);
                        this.gridItemsModel.splice(num,1);
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
            let srfmajortext = record.pcmydjpmxname;
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
            let _keys = keys.length > 1 ? keys : keys[0] ;
            const context:any = JSON.parse(JSON.stringify(this.context));
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ pcmydjpmx: _keys }),Object.assign({ pcmydjpmx: _keys },{viewparams:this.viewparams}), this.showBusyIndicator);
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
                                this.gridItemsModel.splice(index,1);
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
     * @memberof JPGL
     */
    public addBatch(arg: any = {}): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PcmYdjpmxGLGridView视图表格fetchAction参数未配置' });
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
     * @memberof JPGL
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
     * @memberof JPGL
     */
    public exportExcel(data: any = {}): void {
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
                  filename: "异动解聘明细表", //非必填
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
     * @memberof JPGL
     */
    public async formatExcelData(filterVal:any, jsonData:any) {
        let codelistColumns:Array<any> = [
          {
            name: 'yzw',
            srfkey: 'EhrCodeList0233',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'ygw',
            srfkey: 'EhrCodeList0050',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'reason',
            srfkey: 'EhrCodeList0165',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'sfhmd',
            srfkey: 'EhrCodeList0054',
            codelistType : 'STATIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
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
     * @public
     * @param {any[]} items 代码表数据
     * @param {*} value
     * @returns {*}
     * @memberof JPGL
     */
    public getCodelistValue(items: any[], value: any, codelist: any,){
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
     * @public
     * @param {any[]} items
     * @param {*} value
     * @returns {*}
     * @memberof JPGL
     */
    public getItem(items: any[], value: any, codelist: any): any {
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
     * @memberof JPGL
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof JPGL
     */    
    public afterCreated(){
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
     * @memberof JPGL
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof JPGL
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 获取选中行胡数据
     *
     * @returns {any[]}
     * @memberof JPGL
     */
    public getSelection(): any[] {
        return this.selections;
    }

    /**
     * 行双击事件
     *
     * @param {*} $event
     * @returns {void}
     * @memberof JPGL
     */
    public rowDBLClick($event: any): void {
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
     * @memberof  JPGL
     */
    public select($event: any): void {
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
     * @memberof  JPGL
     */
    public selectAll($event: any): void {
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
     * @memberof JPGL
     */
    public rowClick($event: any, ifAlways: boolean = false): void {
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
            return Object.is(item.pcmydjpmx,$event.pcmydjpmx);
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
     * @memberof JPGL
     */
    public pageOnChange($event: any): void {
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
     * @memberof JPGL
     */
    public onPageSizeChange($event: any): void {
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
     * @memberof JPGL
     */
    public pageRefresh(): void {
        this.load({});
    }

    /**
     * 排序变化
     *
     * @param {{ column: any, prop: any, order: any }} { column, prop, order }
     * @memberof JPGL
     */
    public onSortChange({ column, prop, order }: { column: any, prop: any, order: any }): void {
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
     * @memberof JPGL
     */
    public onRowClassName({ row, rowIndex }: { row: any, rowIndex: any }): string {
        const index = this.selections.findIndex((select: any) => Object.is(select.srfkey, row.srfkey));
        return index !== -1 ? 'grid-row-select' : '';
    }



    /**
     * 界面行为
     *
     * @param {*} row
     * @param {*} tag
     * @param {*} $event
     * @memberof JPGL
     */
	public uiAction(row: any, tag: any, $event: any) {
        // this.rowClick(row, true);
    }

    /**
     * 设置列状态
     *
     * @memberof JPGL
     */
    public setColState() {
		const _data: any = localStorage.getItem('pcmydjpmx_jpgl_grid');
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
     * @memberof JPGL
     */
    public onColChange() {
        localStorage.setItem('pcmydjpmx_jpgl_grid', JSON.stringify(this.allColumns));
    }

    /**
     * 获取列状态
     *
     * @param {string} name
     * @returns {boolean}
     * @memberof JPGL
     */
    public getColumnState(name: string): boolean {
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
     * @memberof JPGL
     */
    get adaptiveState(): boolean {
        return !this.allColumns.find((column: any) => column.show && Object.is(column.util, 'STAR'));
    }

    /**
     * 保存
     *
     * @param {*} $event
     * @returns {Promise<any>}
     * @memberof JPGL
     */
    public async save(args: any[], params?: any, $event?: any, xData?: any){
        let _this = this;
        if(!await this.validateAll()){
            this.$Notice.error({ title: '错误', desc: '值规则校验异常' });
            return [];
        }
        let successItems:any = [];
        let errorItems:any = [];
        let errorMessage:any = [];
        for (const item of _this.items) {
            try {
                if(Object.is(item.rowDataState, 'create')){
                    if(!this.createAction){
                        this.$Notice.error({ title: '错误', desc: 'PcmYdjpmxGLGridView视图表格createAction参数未配置' });
                    }else{
                      Object.assign(item,{viewparams:this.viewparams});
                      let response = await this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                      successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }else if(Object.is(item.rowDataState, 'update')){
                    if(!this.updateAction){
                        this.$Notice.error({ title: '错误', desc: 'PcmYdjpmxGLGridView视图表格updateAction参数未配置' });
                    }else{
                        Object.assign(item,{viewparams:this.viewparams});
                        if(item.pcmydjpmx){
                            Object.assign(this.context,{pcmydjpmx:item.pcmydjpmx});
                        }
                        let response = await this.service.add(this.updateAction,JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                        successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }
            } catch (error) {
                errorItems.push(JSON.parse(JSON.stringify(item)));
                errorMessage.push(error);
            }
        }
        this.$emit('save', successItems);
        this.refresh([]);
        if(errorItems.length === 0){
            this.$Notice.success({ title: '', desc: '保存成功!' });
        }else{
          errorItems.forEach((item:any,index:number)=>{
            this.$Notice.error({ title: '保存失败', desc: item.majorentityname+'保存失败！' });
            console.error(errorMessage[index]);
          });
        }
        return successItems;
    }

    /**
     * 新建行
     *
     * @param {*} $event
     * @returns {void}
     * @memberof JPGL
     */
    public newRow(args: any[], params?: any, $event?: any, xData?: any): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PcmYdjpmxGLGridView视图表格loaddraftAction参数未配置' });
            return;
        }
        let _this = this;
        Object.assign(args[0],{viewparams:this.viewparams});
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction, JSON.parse(JSON.stringify(this.context)), args[0], this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.errorMessage) {
                    this.$Notice.error({ title: '错误', desc: response.errorMessage });
                }
                return;
            }
            const data = response.data;
            data.rowDataState = "create";
            _this.items.push(data);
            _this.gridItemsModel.push(_this.getGridRowModel());
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 表格编辑项值变更
     *  
     * @param row 行数据
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof JPGL
     */
    public onGridItemValueChange(row: any,$event: { name: string, value: any },rowIndex: number): void {
        if (!$event) {
            return;
        }
        if (!$event.name || Object.is($event.name, '') || !row.hasOwnProperty($event.name)) {
            return;
        }
        row[$event.name] = $event.value;
        this.gridEditItemChange(row, $event.name, $event.value, rowIndex);
    }

    /**
     * 表格编辑项值变化
     *
     * @public
     * @param row 行数据
     * @param property 列编辑项名
     * @param row 列编辑项值
     * @returns {void}
     * @memberof JPGL
     */
    public gridEditItemChange(row: any, property: string, value: any, rowIndex: number){
        row.rowDataState = row.rowDataState ? row.rowDataState : "update" ;
        this.validate(property,row,rowIndex);
    }

    /**
     * 表格编辑项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof JPGL
     */
    public updateGridEditItem(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        if (!mode || (mode && Object.is(mode, ''))) {
            return;
        }
        const arg: any = JSON.parse(JSON.stringify(data));
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.frontLogic(mode,JSON.parse(JSON.stringify(this.context)),arg, showloading);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: '错误', desc: '表单项更新失败' });
                return;
            }
            const _data: any = response.data;
            if(!_data){
                return;
            }
            updateDetails.forEach((name: string) => {
                if (!_data.hasOwnProperty(name)) {
                    return;
                }
                data[name] = _data[name];
            });
        }).catch((response: any) => {
            if (response && response.status === 401) {
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 获取对应行class
     *
     * @param {*} $args row 行数据，rowIndex 行索引
     * @returns {void}
     * @memberof JPGL
     */
    public getRowClassName(args:{row: any,rowIndex: number}){
        let isSelected = this.selections.some((item:any)=>{
            return Object.is(item.pcmydjpmx,args.row.pcmydjpmx);
        });
        return isSelected ? "grid-selected-row" : "";
    }
}
</script>

<style lang='less'>
@import './jpgl-grid.less';
</style>