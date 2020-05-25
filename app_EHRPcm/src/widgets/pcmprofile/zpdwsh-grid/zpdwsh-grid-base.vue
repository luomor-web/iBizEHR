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
            <template slot="empty">
                无数据 
                <span class="quick-toolbar">
                </span>
            </template>
            <template v-if="!isSingleSelect">
                <el-table-column align="center" type='selection' :width="checkboxColWidth"></el-table-column>
            </template>
            <template v-if="getColumnState('cz2')">
                <el-table-column show-overflow-tooltip :prop="'cz2'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.cz2')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.cz2}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zzdzs')">
                <el-table-column show-overflow-tooltip :prop="'zzdzs'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.zzdzs')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.zzdzs}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pcmprofilename')">
                <el-table-column show-overflow-tooltip :prop="'pcmprofilename'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.pcmprofilename')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.pcmprofilename}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('rzqd')">
                <el-table-column show-overflow-tooltip :prop="'rzqd'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.rzqd')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.rzqd" tag='PIMCL_RZLB' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xznf')">
                <el-table-column show-overflow-tooltip :prop="'xznf'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.xznf')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.xznf" tag='PIMCL_ND2' codelistType='STATIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('yglx')">
                <el-table-column show-overflow-tooltip :prop="'yglx'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.yglx')" :width="120"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.yglx" tag='PCMCL_SBLX' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('educationlevel')">
                <el-table-column show-overflow-tooltip :prop="'educationlevel'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.educationlevel')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.educationlevel" tag='PIM_XL2' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('r_lastschool')">
                <el-table-column show-overflow-tooltip :prop="'r_lastschool'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.r_lastschool')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.r_lastschool}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xkml')">
                <el-table-column show-overflow-tooltip :prop="'xkml'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.xkml')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.xkml" tag='PCMCL_XKML' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('r_lastdiscipline')">
                <el-table-column show-overflow-tooltip :prop="'r_lastdiscipline'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.r_lastdiscipline')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.r_lastdiscipline}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xxxz')">
                <el-table-column show-overflow-tooltip :prop="'xxxz'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.xxxz')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.xxxz" tag='PIMCL_XXXZ' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('yydjmc')">
                <el-table-column show-overflow-tooltip :prop="'yydjmc'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.yydjmc')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.yydjmc}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('certificatetype')">
                <el-table-column show-overflow-tooltip :prop="'certificatetype'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.certificatetype')" :width="120"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.certificatetype" tag='PIMCL_ZJLX' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('certificatenumber')">
                <el-table-column show-overflow-tooltip :prop="'certificatenumber'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.certificatenumber')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.certificatenumber}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('gender')">
                <el-table-column show-overflow-tooltip :prop="'gender'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.gender')" :width="90"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.gender" tag='PIMCL_XB' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('nl')">
                <el-table-column show-overflow-tooltip :prop="'nl'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.nl')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.nl}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('mobile')">
                <el-table-column show-overflow-tooltip :prop="'mobile'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.mobile')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.mobile}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('email')">
                <el-table-column show-overflow-tooltip :prop="'email'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.email')" :width="180"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <span>{{row.email}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('profiletype')">
                <el-table-column show-overflow-tooltip :prop="'profiletype'" :label="$t('entities.pcmprofile.zpdwsh_grid.columns.profiletype')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot="{row,column}">
                        <template >
            <codelist :value="row.profiletype" tag='PCMCL_PROFILEType' codelistType='STATIC' ></codelist>
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
</div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PCMPROFILEService from '@/service/pcmprofile/pcmprofile-service';
import ZPDWSHService from './zpdwsh-grid-service';

import CodeListService from "@service/app/codelist-service";


@Component({
    components: {
      
    }
})
export default class ZPDWSHBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof ZPDWSH
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof ZPDWSH
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof ZPDWSH
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof ZPDWSH
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof ZPDWSH
     */
    public getControlType(): string {
        return 'GRID'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof ZPDWSH
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {ZPDWSHService}
     * @memberof ZPDWSH
     */
    public service: ZPDWSHService = new ZPDWSHService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PCMPROFILEService}
     * @memberof ZPDWSH
     */
    public appEntityService: PCMPROFILEService = new PCMPROFILEService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof ZPDWSH
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof ZPDWSH
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof ZPDWSH
     */
    public getData(): any {
        return this.selections[0];
    }

    /**
     * 打开新建数据视图
     *
     * @type {any}
     * @memberof ZPDWSH
     */
    @Prop() public newdata: any;
    /**
     * 打开编辑数据视图
     *
     * @type {any}
     * @memberof ZPDWSH
     */
    @Prop() public opendata: any;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof ZPDWSH
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    @Prop() public fetchAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    @Prop() public createAction!: string;

    /**
     * 当前页
     *
     * @type {number}
     * @memberof ZPDWSH
     */
    public curPage: number = 1;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof ZPDWSH
     */
    public items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof ZPDWSH
     */
    public isEnablePagingBar: boolean = true;

    /**
     * 是否禁用排序
     *
     * @type {boolean}
     * @memberof ZPDWSH
     */
    public isNoSort: boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    public minorSortDir: string = 'DESC';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof ZPDWSH
     */
    public minorSortPSDEF: string = 'updatedate';

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof ZPDWSH
     */
    public limit: number = 20;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof ZPDWSH
     */
    public isHideHeader: boolean = false;

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof ZPDWSH
     */
    @Prop({ default: false }) public isSelectFirstDefault!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof ZPDWSH
     */
    @Prop() public isSingleSelect?: boolean;

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
    @Prop({default: 2}) public gridRowActiveMode!: number;

    /**
     * 是否开启行编辑
     *
     * @type {boolean}
     * @memberof ZPDWSH
     */
    @Prop({default: false}) public isOpenEdit!: boolean;

    /**
     * 实际是否开启行编辑
     *
     * @type {boolean}
     * @memberof ZPDWSH
     */
    public actualIsOpenEdit: boolean = this.isOpenEdit;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
    public isDisplay:boolean = true;

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
    public allColumns: any[] = [
        {
            name: 'cz2',
            label: '操作',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.cz2',
            show: true,
            util: 'PX'
        },
        {
            name: 'zzdzs',
            label: '组织名称',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.zzdzs',
            show: true,
            util: 'PX'
        },
        {
            name: 'pcmprofilename',
            label: '姓名',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.pcmprofilename',
            show: true,
            util: 'PX'
        },
        {
            name: 'rzqd',
            label: '入职渠道',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.rzqd',
            show: true,
            util: 'PX'
        },
        {
            name: 'xznf',
            label: '招聘年份',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.xznf',
            show: true,
            util: 'px'
        },
        {
            name: 'yglx',
            label: '申报类型',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.yglx',
            show: true,
            util: 'PX'
        },
        {
            name: 'educationlevel',
            label: '最高学历',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.educationlevel',
            show: true,
            util: 'px'
        },
        {
            name: 'r_lastschool',
            label: '毕业学校',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.r_lastschool',
            show: true,
            util: 'px'
        },
        {
            name: 'xkml',
            label: '一级学科',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.xkml',
            show: true,
            util: 'px'
        },
        {
            name: 'r_lastdiscipline',
            label: '专业名称',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.r_lastdiscipline',
            show: true,
            util: 'px'
        },
        {
            name: 'xxxz',
            label: '学校性质',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.xxxz',
            show: true,
            util: 'px'
        },
        {
            name: 'yydjmc',
            label: '语言等级名称',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.yydjmc',
            show: true,
            util: 'px'
        },
        {
            name: 'certificatetype',
            label: '证件类型',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.certificatetype',
            show: true,
            util: 'PX'
        },
        {
            name: 'certificatenumber',
            label: '证件号码',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.certificatenumber',
            show: true,
            util: 'PX'
        },
        {
            name: 'gender',
            label: '性别',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.gender',
            show: true,
            util: 'PX'
        },
        {
            name: 'nl',
            label: '年龄',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.nl',
            show: true,
            util: 'px'
        },
        {
            name: 'mobile',
            label: '手机号',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.mobile',
            show: true,
            util: 'px'
        },
        {
            name: 'email',
            label: '邮箱',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.email',
            show: true,
            util: 'PX'
        },
        {
            name: 'profiletype',
            label: '应聘者状态',
            langtag: 'entities.pcmprofile.zpdwsh_grid.columns.profiletype',
            show: true,
            util: 'px'
        },
    ]

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof ZPDWSH
     */
    public rules: any = {
        srfkey: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '应聘者ID 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '应聘者ID 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 表格数据加载
     *
     * @param {*} [arg={}]
     * @memberof ZPDWSH
     */
    public load(opt: any = {}, pageReset: boolean = false): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILEZPDWSHGridView视图表格fetchAction参数未配置' });
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
     * @memberof ZPDWSH
     */
    public async remove(datas: any[]): Promise<any> {
        if(!this.removeAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILEZPDWSHGridView视图表格removeAction参数未配置' });
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
            let srfmajortext = record.pcmprofilename;
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
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ pcmprofile: keys.join(';') }),Object.assign({ pcmprofile: keys.join(';') },{viewparams:this.viewparams}), this.showBusyIndicator);
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
     * @memberof ZPDWSH
     */
    public addBatch(arg: any = {}): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILEZPDWSHGridView视图表格fetchAction参数未配置' });
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
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
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
                  filename: "应聘者基本信息表", //非必填
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
     * @memberof ZPDWSH
     */
    public async formatExcelData(filterVal:any, jsonData:any) {
        let codelistColumns:Array<any> = [
          {
            name: 'rzqd',
            srfkey: 'PIMCL_RZLB',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'xznf',
            srfkey: 'PIMCL_ND2',
            codelistType : 'STATIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'yglx',
            srfkey: 'PCMCL_SBLX',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'educationlevel',
            srfkey: 'PIM_XL2',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'xkml',
            srfkey: 'PCMCL_XKML',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'xxxz',
            srfkey: 'PIMCL_XXXZ',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'certificatetype',
            srfkey: 'PIMCL_ZJLX',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'gender',
            srfkey: 'PIMCL_XB',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'profiletype',
            srfkey: 'PCMCL_PROFILEType',
            codelistType : 'STATIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
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
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
    public getSelection(): any[] {
        return this.selections;
    }

    /**
     * 行双击事件
     *
     * @param {*} $event
     * @returns {void}
     * @memberof ZPDWSH
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
     * @memberof  ZPDWSH
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
     * @memberof  ZPDWSH
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
     * @memberof ZPDWSH
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
            return Object.is(item.pcmprofile,$event.pcmprofile);
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
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
    public pageRefresh(): void {
        this.load({});
    }

    /**
     * 排序变化
     *
     * @param {{ column: any, prop: any, order: any }} { column, prop, order }
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
	public uiAction(row: any, tag: any, $event: any) {
        // this.rowClick(row, true);
    }

    /**
     * 设置列状态
     *
     * @memberof ZPDWSH
     */
    public setColState() {
		const _data: any = localStorage.getItem('pcmprofile_zpdwsh_grid');
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
     * @memberof ZPDWSH
     */
    public onColChange() {
        localStorage.setItem('pcmprofile_zpdwsh_grid', JSON.stringify(this.allColumns));
    }

    /**
     * 获取列状态
     *
     * @param {string} name
     * @returns {boolean}
     * @memberof ZPDWSH
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
     * @memberof ZPDWSH
     */
    get adaptiveState(): boolean {
        return !this.allColumns.find((column: any) => column.show && Object.is(column.util, 'STAR'));
    }

    /**
     * 保存
     *
     * @param {*} $event
     * @returns {void}
     * @memberof ZPDWSH
     */
    public save(args: any[], params?: any, $event?: any, xData?: any): void {
        let _this = this;
        let promises:any = [];
        _this.items.forEach((item:any)=>{
            if(!item.rowDataState){
                return;
            } else if(Object.is(item.rowDataState, 'create')){
                if(!this.createAction){
                    this.$Notice.error({ title: '错误', desc: 'PCMPROFILEZPDWSHGridView视图表格createAction参数未配置' });
                    return;
                }
                Object.assign(item,{viewparams:this.viewparams});
                promises.push(this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator));
            }else if(Object.is(item.rowDataState, 'update')){
                if(!this.updateAction){
                    this.$Notice.error({ title: '错误', desc: 'PCMPROFILEZPDWSHGridView视图表格updateAction参数未配置' });
                    return;
                }
                Object.assign(item,{viewparams:this.viewparams});
                if(item.pcmprofile){
                    Object.assign(this.context,{pcmprofile:item.pcmprofile})
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
     * @memberof ZPDWSH
     */
    public getRowClassName(args:{row: any,rowIndex: number}){
        let isSelected = this.selections.some((item:any)=>{
            return Object.is(item.pcmprofile,args.row.pcmprofile);
        });
        return isSelected ? "grid-selected-row" : "";
    }
}
</script>

<style lang='less'>
@import './zpdwsh-grid.less';
</style>