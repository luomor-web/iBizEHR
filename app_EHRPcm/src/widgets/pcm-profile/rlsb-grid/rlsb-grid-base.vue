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
            <template v-if="getColumnState('uagridcolumn1')">
                <el-table-column :column-key="'uagridcolumn1'" :label="$t('entities.pcmprofile.rlsb_grid.columns.uagridcolumn1')" :width="100"  :align="'center'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.uagridcolumn1')}}
                      </span>
                    </template>
                    <template slot-scope="scope">
                        <span>
                            
                            <a @click="uiAction(scope.row, 'ModifyYPZ', $event)">
                              <i class=''></i>
                              {{$t('entities.pcmprofile.rlsb_grid.uiactions.modifyypz')}}
                            </a>
                        </span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zzdzs')">
                <el-table-column show-overflow-tooltip :prop="'zzdzs'" :label="$t('entities.pcmprofile.rlsb_grid.columns.zzdzs')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.zzdzs')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.zzdzs}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pcmprofilename')">
                <el-table-column show-overflow-tooltip :prop="'pcmprofilename'" :label="$t('entities.pcmprofile.rlsb_grid.columns.pcmprofilename')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.pcmprofilename')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.pcmprofilename}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('rzqd')">
                <el-table-column show-overflow-tooltip :prop="'rzqd'" :label="$t('entities.pcmprofile.rlsb_grid.columns.rzqd')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.rzqd')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.rzqd" tag='PIMCL_RZLB' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xznf')">
                <el-table-column show-overflow-tooltip :prop="'xznf'" :label="$t('entities.pcmprofile.rlsb_grid.columns.xznf')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.xznf')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.xznf" tag='PIMCL_ND2' codelistType='STATIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('yglx')">
                <el-table-column show-overflow-tooltip :prop="'yglx'" :label="$t('entities.pcmprofile.rlsb_grid.columns.yglx')" :width="120"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.yglx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PCMCL_SBLX' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.yglx" tag='PCMCL_SBLX' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('profiletype')">
                <el-table-column show-overflow-tooltip :prop="'profiletype'" :label="$t('entities.pcmprofile.rlsb_grid.columns.profiletype')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.profiletype')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.profiletype" tag='PCMCL_PROFILEType' codelistType='STATIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('jspyj_rlsb')">
                <el-table-column show-overflow-tooltip :prop="'jspyj_rlsb'" :label="$t('entities.pcmprofile.rlsb_grid.columns.jspyj_rlsb')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.jspyj_rlsb')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.jspyj_rlsb}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('educationlevel')">
                <el-table-column show-overflow-tooltip :prop="'educationlevel'" :label="$t('entities.pcmprofile.rlsb_grid.columns.educationlevel')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.educationlevel')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.educationlevel" tag='PIM_XL2' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('r_lastschool')">
                <el-table-column show-overflow-tooltip :prop="'r_lastschool'" :label="$t('entities.pcmprofile.rlsb_grid.columns.r_lastschool')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.r_lastschool')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.r_lastschool}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xkml')">
                <el-table-column show-overflow-tooltip :prop="'xkml'" :label="$t('entities.pcmprofile.rlsb_grid.columns.xkml')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.xkml')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.xkml" tag='PCMCL_XKML' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('r_lastdiscipline')">
                <el-table-column show-overflow-tooltip :prop="'r_lastdiscipline'" :label="$t('entities.pcmprofile.rlsb_grid.columns.r_lastdiscipline')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.r_lastdiscipline')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.r_lastdiscipline}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xxxz')">
                <el-table-column show-overflow-tooltip :prop="'xxxz'" :label="$t('entities.pcmprofile.rlsb_grid.columns.xxxz')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.xxxz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.xxxz" tag='PIMCL_XXXZ' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('yydjmc')">
                <el-table-column show-overflow-tooltip :prop="'yydjmc'" :label="$t('entities.pcmprofile.rlsb_grid.columns.yydjmc')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.yydjmc')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.yydjmc}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('bz')">
                <el-table-column show-overflow-tooltip :prop="'bz'" :label="$t('entities.pcmprofile.rlsb_grid.columns.bz')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.bz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.bz}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('certificatetype')">
                <el-table-column show-overflow-tooltip :prop="'certificatetype'" :label="$t('entities.pcmprofile.rlsb_grid.columns.certificatetype')" :width="120"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.certificatetype')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.certificatetype" tag='PIMCL_ZJLX' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('certificatenumber')">
                <el-table-column show-overflow-tooltip :prop="'certificatenumber'" :label="$t('entities.pcmprofile.rlsb_grid.columns.certificatenumber')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.certificatenumber')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.certificatenumber}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('gender')">
                <el-table-column show-overflow-tooltip :prop="'gender'" :label="$t('entities.pcmprofile.rlsb_grid.columns.gender')" :width="90"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.gender')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.gender" tag='PIMCL_XB' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('mobile')">
                <el-table-column show-overflow-tooltip :prop="'mobile'" :label="$t('entities.pcmprofile.rlsb_grid.columns.mobile')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmprofile.rlsb_grid.columns.mobile')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.mobile}}</span>
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
import PcmProfileService from '@/service/pcm-profile/pcm-profile-service';
import RLSBService from './rlsb-grid-service';

import PcmProfileUIService from '@/uiservice/pcm-profile/pcm-profile-ui-service';
import CodeListService from "@service/app/codelist-service";
import { FormItemModel } from '@/model/form-detail';


@Component({
    components: {
      
    }
})
export default class RLSBBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof RLSB
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof RLSB
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof RLSB
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof RLSB
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof RLSB
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof RLSB
     */
    public getControlType(): string {
        return 'GRID'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof RLSB
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {RLSBService}
     * @memberof RLSB
     */
    public service: RLSBService = new RLSBService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PcmProfileService}
     * @memberof RLSB
     */
    public appEntityService: PcmProfileService = new PcmProfileService({ $store: this.$store });
    

    /**
     * 逻辑事件
     *
     * @param {*} [params={}]
     * @param {*} [tag]
     * @param {*} [$event]
     * @memberof 
     */
    public grid_uagridcolumn1_ue2a3f8a_click(params: any = {}, tag?: any, $event?: any) {
        // 取数
        let datas: any[] = [];
        let xData: any = null;
        // _this 指向容器对象
        const _this: any = this;
        let paramJO:any = {};
        
        let contextJO:any = {};
        xData = this;
        if (_this.getDatas && _this.getDatas instanceof Function) {
            datas = [..._this.getDatas()];
        }
        if(params){
          datas = [params];
        }
        // 界面行为
        const curUIService:PcmProfileUIService  = new PcmProfileUIService();
        curUIService.PcmProfile_ModifyYPZ(datas,contextJO, paramJO,  $event, xData,this,"PcmProfile");
    }


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof RLSB
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof RLSB
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
     * @memberof RLSB
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof RLSB
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof RLSB
     */
    public getData(): any {
        return this.selections[0];
    }

    /**
     * 打开新建数据视图
     *
     * @type {any}
     * @memberof RLSB
     */
    @Prop() public newdata: any;
    /**
     * 打开编辑数据视图
     *
     * @type {any}
     * @memberof RLSB
     */
    @Prop() public opendata: any;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof RLSB
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof RLSB
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof RLSB
     */
    @Prop() public fetchAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof RLSB
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof RLSB
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof RLSB
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof RLSB
     */
    @Prop() public createAction!: string;

    /**
     * 当前页
     *
     * @type {number}
     * @memberof RLSB
     */
    public curPage: number = 1;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof RLSB
     */
    public items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof RLSB
     */
    public isEnablePagingBar: boolean = true;

    /**
     * 是否禁用排序
     *
     * @type {boolean}
     * @memberof RLSB
     */
    public isNoSort: boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof RLSB
     */
    public minorSortDir: string = '';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof RLSB
     */
    public minorSortPSDEF: string = '';

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof RLSB
     */
    public limit: number = 20;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof RLSB
     */
    public isHideHeader: boolean = false;

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof RLSB
     */
    @Prop({ default: false }) public isSelectFirstDefault!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof RLSB
     */
    @Prop() public isSingleSelect?: boolean;

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof RLSB
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
     * @memberof RLSB
     */
    @Prop({default: 2}) public gridRowActiveMode!: number;

    /**
     * 是否开启行编辑
     *
     * @type {boolean}
     * @memberof RLSB
     */
    @Prop({default: false}) public isOpenEdit!: boolean;

    /**
     * 实际是否开启行编辑
     *
     * @type {boolean}
     * @memberof RLSB
     */
    public actualIsOpenEdit: boolean = this.isOpenEdit;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof RLSB
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
     * @memberof RLSB
     */
    public isDisplay:boolean = true;

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof RLSB
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
     * @memberof RLSB
     */
    public allColumns: any[] = [
        {
            name: 'uagridcolumn1',
            label: '操作列',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.uagridcolumn1',
            show: true,
            util: 'PX'
        },
        {
            name: 'zzdzs',
            label: '组织名称',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.zzdzs',
            show: true,
            util: 'PX'
        },
        {
            name: 'pcmprofilename',
            label: '姓名',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.pcmprofilename',
            show: true,
            util: 'PX'
        },
        {
            name: 'rzqd',
            label: '入职渠道',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.rzqd',
            show: true,
            util: 'PX'
        },
        {
            name: 'xznf',
            label: '招聘年份',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.xznf',
            show: true,
            util: 'px'
        },
        {
            name: 'yglx',
            label: '申报类型',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.yglx',
            show: true,
            util: 'PX'
        },
        {
            name: 'profiletype',
            label: '应聘者状态',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.profiletype',
            show: true,
            util: 'px'
        },
        {
            name: 'jspyj_rlsb',
            label: '局总部意见',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.jspyj_rlsb',
            show: true,
            util: 'PX'
        },
        {
            name: 'educationlevel',
            label: '最高学历',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.educationlevel',
            show: true,
            util: 'px'
        },
        {
            name: 'r_lastschool',
            label: '毕业学校',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.r_lastschool',
            show: true,
            util: 'px'
        },
        {
            name: 'xkml',
            label: '一级学科',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.xkml',
            show: true,
            util: 'px'
        },
        {
            name: 'r_lastdiscipline',
            label: '专业名称',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.r_lastdiscipline',
            show: true,
            util: 'px'
        },
        {
            name: 'xxxz',
            label: '学校性质',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.xxxz',
            show: true,
            util: 'px'
        },
        {
            name: 'yydjmc',
            label: '语言等级名称',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.yydjmc',
            show: true,
            util: 'px'
        },
        {
            name: 'bz',
            label: '备注',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.bz',
            show: true,
            util: 'PX'
        },
        {
            name: 'certificatetype',
            label: '证件类型',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.certificatetype',
            show: true,
            util: 'PX'
        },
        {
            name: 'certificatenumber',
            label: '证件号码',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.certificatenumber',
            show: true,
            util: 'PX'
        },
        {
            name: 'gender',
            label: '性别',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.gender',
            show: true,
            util: 'PX'
        },
        {
            name: 'mobile',
            label: '手机号',
            langtag: 'entities.pcmprofile.rlsb_grid.columns.mobile',
            show: true,
            util: 'px'
        },
    ]

    /**
     * 表格模型集合
     *
     * @type {*}
     * @memberof RLSB
     */
    public gridItemsModel: any[] = [];

    /**
     * 获取表格行模型
     *
     * @type {*}
     * @memberof RLSB
     */
    public getGridRowModel(){
        return {
          yglx: new FormItemModel(),
          srfkey: new FormItemModel(),
        }
    }

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof RLSB
     */
    public rules: any = {
        yglx: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '申报类型 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '申报类型 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '应聘者ID 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '应聘者ID 值不能为空', trigger: 'blur' },
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
     * @memberof RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
     */
    public load(opt: any = {}, pageReset: boolean = false): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILERLSBGridView视图表格fetchAction参数未配置' });
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
     * @memberof RLSB
     */
    public async remove(datas: any[]): Promise<any> {
        if(!this.removeAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILERLSBGridView视图表格removeAction参数未配置' });
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
            let _keys = keys.length > 1 ? keys : keys[0] ;
            const context:any = JSON.parse(JSON.stringify(this.context));
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ pcmprofile: _keys }),Object.assign({ pcmprofile: _keys },{viewparams:this.viewparams}), this.showBusyIndicator);
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
     * @memberof RLSB
     */
    public addBatch(arg: any = {}): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILERLSBGridView视图表格fetchAction参数未配置' });
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
     * @memberof RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
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
            name: 'profiletype',
            srfkey: 'PCMCL_PROFILEType',
            codelistType : 'STATIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
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
     * @memberof RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof RLSB
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
     * @memberof RLSB
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof RLSB
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
     * @memberof RLSB
     */
    public getSelection(): any[] {
        return this.selections;
    }

    /**
     * 行双击事件
     *
     * @param {*} $event
     * @returns {void}
     * @memberof RLSB
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
     * @memberof  RLSB
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
     * @memberof  RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
     */
    public pageRefresh(): void {
        this.load({});
    }

    /**
     * 排序变化
     *
     * @param {{ column: any, prop: any, order: any }} { column, prop, order }
     * @memberof RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
     */
	public uiAction(row: any, tag: any, $event: any) {
        // this.rowClick(row, true);
        if(Object.is('ModifyYPZ', tag)) {
            this.grid_uagridcolumn1_ue2a3f8a_click(row, tag, $event);
        }
    }

    /**
     * 设置列状态
     *
     * @memberof RLSB
     */
    public setColState() {
		const _data: any = localStorage.getItem('pcmprofile_rlsb_grid');
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
     * @memberof RLSB
     */
    public onColChange() {
        localStorage.setItem('pcmprofile_rlsb_grid', JSON.stringify(this.allColumns));
    }

    /**
     * 获取列状态
     *
     * @param {string} name
     * @returns {boolean}
     * @memberof RLSB
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
     * @memberof RLSB
     */
    get adaptiveState(): boolean {
        return !this.allColumns.find((column: any) => column.show && Object.is(column.util, 'STAR'));
    }

    /**
     * 保存
     *
     * @param {*} $event
     * @returns {Promise<any>}
     * @memberof RLSB
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
                        this.$Notice.error({ title: '错误', desc: 'PCMPROFILERLSBGridView视图表格createAction参数未配置' });
                    }else{
                      Object.assign(item,{viewparams:this.viewparams});
                      let response = await this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                      successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }else if(Object.is(item.rowDataState, 'update')){
                    if(!this.updateAction){
                        this.$Notice.error({ title: '错误', desc: 'PCMPROFILERLSBGridView视图表格updateAction参数未配置' });
                    }else{
                        Object.assign(item,{viewparams:this.viewparams});
                        if(item.pcmprofile){
                            Object.assign(this.context,{pcmprofile:item.pcmprofile});
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
     * @memberof RLSB
     */
    public newRow(args: any[], params?: any, $event?: any, xData?: any): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PCMPROFILERLSBGridView视图表格loaddraftAction参数未配置' });
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
     * @memberof RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
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
     * @memberof RLSB
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
@import './rlsb-grid.less';
</style>