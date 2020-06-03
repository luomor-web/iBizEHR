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
            <template v-if="getColumnState('xl')">
                <el-table-column show-overflow-tooltip :prop="'xl'" :label="$t('entities.pcmeducationexperience.main_grid.columns.xl')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.xl')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='EhrCodeList0117' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.xl" tag='EhrCodeList0117' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('starttime')">
                <el-table-column show-overflow-tooltip :prop="'starttime'" :label="$t('entities.pcmeducationexperience.main_grid.columns.starttime')" :width="140"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.starttime')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" :value="row[column.property]" style="" @on-change="(val1, val2) => { row[column.property] = val1; gridEditItemChange(row, column.property, val1, $index)}"></date-picker>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
                                <app-span name='starttime' editorType="DATEPICKER" :value="row.starttime"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('endtime')">
                <el-table-column show-overflow-tooltip :prop="'endtime'" :label="$t('entities.pcmeducationexperience.main_grid.columns.endtime')" :width="140"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.endtime')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" :value="row[column.property]" style="" @on-change="(val1, val2) => { row[column.property] = val1; gridEditItemChange(row, column.property, val1, $index)}"></date-picker>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
                                <app-span name='endtime' editorType="DATEPICKER" :value="row.endtime"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('schoolname')">
                <el-table-column show-overflow-tooltip :prop="'schoolname'" :label="$t('entities.pcmeducationexperience.main_grid.columns.schoolname')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.schoolname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                <input-box 
              :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" 
              v-model="row[column.property]" 
              style=""
              type="text"
              
              
              @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}">
            </input-box>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
                                <app-span name='schoolname' editorType="TEXTBOX" :value="row.schoolname"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xkml')">
                <el-table-column show-overflow-tooltip :prop="'xkml'" :label="$t('entities.pcmeducationexperience.main_grid.columns.xkml')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.xkml')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='EhrCodeList0093' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.xkml" tag='EhrCodeList0093' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('majorname')">
                <el-table-column show-overflow-tooltip :prop="'majorname'" :label="$t('entities.pcmeducationexperience.main_grid.columns.majorname')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.majorname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                <input-box 
              :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" 
              v-model="row[column.property]" 
              style=""
              type="text"
              
              
              @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}">
            </input-box>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
                                <app-span name='majorname' editorType="TEXTBOX" :value="row.majorname"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xxxz')">
                <el-table-column show-overflow-tooltip :prop="'xxxz'" :label="$t('entities.pcmeducationexperience.main_grid.columns.xxxz')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.xxxz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='EhrCodeList0208' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.xxxz" tag='EhrCodeList0208' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('formsoflearning')">
                <el-table-column show-overflow-tooltip :prop="'formsoflearning'" :label="$t('entities.pcmeducationexperience.main_grid.columns.formsoflearning')" :width="180"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.formsoflearning')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='EhrCodeList0131' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.formsoflearning" tag='EhrCodeList0131' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('firstxl')">
                <el-table-column show-overflow-tooltip :prop="'firstxl'" :label="$t('entities.pcmeducationexperience.main_grid.columns.firstxl')" :width="140"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.firstxl')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='EhrCodeList0054' codelistType='STATIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.firstxl" tag='EhrCodeList0054' codelistType='STATIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('higestxl')">
                <el-table-column show-overflow-tooltip :prop="'higestxl'" :label="$t('entities.pcmeducationexperience.main_grid.columns.higestxl')" :width="140"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.higestxl')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='EhrCodeList0054' codelistType='STATIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.higestxl" tag='EhrCodeList0054' codelistType='STATIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('byz')">
                <el-table-column show-overflow-tooltip :prop="'byz'" :label="$t('entities.pcmeducationexperience.main_grid.columns.byz')" :width="190"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.byz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                <input-box 
              :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" 
              v-model="row[column.property]" 
              style=""
              type="text"
              
              
              @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}">
            </input-box>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
                                <app-span name='byz' editorType="TEXTBOX" :value="row.byz"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xwz')">
                <el-table-column show-overflow-tooltip :prop="'xwz'" :label="$t('entities.pcmeducationexperience.main_grid.columns.xwz')" :width="190"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.xwz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                <input-box 
              :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" 
              v-model="row[column.property]" 
              style=""
              type="text"
              
              
              @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}">
            </input-box>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
                                <app-span name='xwz' editorType="TEXTBOX" :value="row.xwz"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xlyz')">
                <el-table-column show-overflow-tooltip :prop="'xlyz'" :label="$t('entities.pcmeducationexperience.main_grid.columns.xlyz')" :width="190"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmeducationexperience.main_grid.columns.xlyz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                <input-box 
              :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" 
              v-model="row[column.property]" 
              style=""
              type="text"
              
              
              @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}">
            </input-box>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
                                <app-span name='xlyz' editorType="TEXTBOX" :value="row.xlyz"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="adaptiveState">
                <el-table-column></el-table-column>
            </template>
    </el-table>
  
  </i-form>
</div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PcmEducationExperienceService from '@/service/pcm-education-experience/pcm-education-experience-service';
import MainService from './main-grid-service';

import CodeListService from "@service/app/codelist-service";
import { FormItemModel } from '@/model/form-detail';


@Component({
    components: {
      
    }
})
export default class MainBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof Main
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof Main
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof Main
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof Main
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof Main
     */
    public getControlType(): string {
        return 'GRID'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof Main
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {MainService}
     * @memberof Main
     */
    public service: MainService = new MainService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PcmEducationExperienceService}
     * @memberof Main
     */
    public appEntityService: PcmEducationExperienceService = new PcmEducationExperienceService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof Main
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof Main
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
     * @memberof Main
     */  
    public codeListService:CodeListService = new CodeListService({ $store: this.$store });

    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof Main
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof Main
     */
    public getData(): any {
        return this.selections[0];
    }

    /**
     * 打开新建数据视图
     *
     * @type {any}
     * @memberof Main
     */
    @Prop() public newdata: any;
    /**
     * 打开编辑数据视图
     *
     * @type {any}
     * @memberof Main
     */
    @Prop() public opendata: any;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof Main
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public fetchAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof Main
     */
    @Prop() public createAction!: string;

    /**
     * 当前页
     *
     * @type {number}
     * @memberof Main
     */
    public curPage: number = 1;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof Main
     */
    public items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof Main
     */
    public isEnablePagingBar: boolean = false;

    /**
     * 是否禁用排序
     *
     * @type {boolean}
     * @memberof Main
     */
    public isNoSort: boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof Main
     */
    public minorSortDir: string = 'DESC';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof Main
     */
    public minorSortPSDEF: string = 'endtime';

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof Main
     */
    public limit: number = 20;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof Main
     */
    public isHideHeader: boolean = false;

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof Main
     */
    @Prop({ default: false }) public isSelectFirstDefault!: boolean;

    /**
     * 是否单选
     *
     * @type {boolean}
     * @memberof Main
     */
    @Prop() public isSingleSelect?: boolean;

    /**
     * 选中数据字符串
     *
     * @type {string}
     * @memberof Main
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
     * @memberof Main
     */
    @Prop({default: 2}) public gridRowActiveMode!: number;

    /**
     * 是否开启行编辑
     *
     * @type {boolean}
     * @memberof Main
     */
    @Prop({default: false}) public isOpenEdit!: boolean;

    /**
     * 实际是否开启行编辑
     *
     * @type {boolean}
     * @memberof Main
     */
    public actualIsOpenEdit: boolean = this.isOpenEdit;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof Main
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
     * @memberof Main
     */
    public isDisplay:boolean = true;

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof Main
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
     * @memberof Main
     */
    public allColumns: any[] = [
        {
            name: 'xl',
            label: '学历（*）',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.xl',
            show: true,
            util: 'PX'
        },
        {
            name: 'starttime',
            label: '入学时间（*）',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.starttime',
            show: true,
            util: 'PX'
        },
        {
            name: 'endtime',
            label: '毕业时间（*）',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.endtime',
            show: true,
            util: 'PX'
        },
        {
            name: 'schoolname',
            label: '毕业院校（*）',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.schoolname',
            show: true,
            util: 'PX'
        },
        {
            name: 'xkml',
            label: '一级学科（*）',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.xkml',
            show: true,
            util: 'PX'
        },
        {
            name: 'majorname',
            label: '专业名称（*）',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.majorname',
            show: true,
            util: 'PX'
        },
        {
            name: 'xxxz',
            label: '学校性质',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.xxxz',
            show: true,
            util: 'PX'
        },
        {
            name: 'formsoflearning',
            label: '学习形式',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.formsoflearning',
            show: true,
            util: 'PX'
        },
        {
            name: 'firstxl',
            label: '是否第一学历',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.firstxl',
            show: true,
            util: 'PX'
        },
        {
            name: 'higestxl',
            label: '是否最高学历',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.higestxl',
            show: true,
            util: 'PX'
        },
        {
            name: 'byz',
            label: '毕业证（*）',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.byz',
            show: true,
            util: 'PX'
        },
        {
            name: 'xwz',
            label: '学位证（*）',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.xwz',
            show: true,
            util: 'PX'
        },
        {
            name: 'xlyz',
            label: '学历验证',
            langtag: 'entities.pcmeducationexperience.main_grid.columns.xlyz',
            show: true,
            util: 'PX'
        },
    ]

    /**
     * 表格模型集合
     *
     * @type {*}
     * @memberof Main
     */
    public gridItemsModel: any[] = [];

    /**
     * 获取表格行模型
     *
     * @type {*}
     * @memberof Main
     */
    public getGridRowModel(){
        return {
          xwz: new FormItemModel(),
          firstxl: new FormItemModel(),
          endtime: new FormItemModel(),
          schoolname: new FormItemModel(),
          starttime: new FormItemModel(),
          xkml: new FormItemModel(),
          xl: new FormItemModel(),
          higestxl: new FormItemModel(),
          formsoflearning: new FormItemModel(),
          xxxz: new FormItemModel(),
          xlyz: new FormItemModel(),
          majorname: new FormItemModel(),
          byz: new FormItemModel(),
          pcmprofileid: new FormItemModel(),
          srfkey: new FormItemModel(),
        }
    }

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof Main
     */
    public rules: any = {
        xwz: [
             { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学位证（*） 值不能为空', trigger: 'change' },
            { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学位证（*） 值不能为空', trigger: 'blur' },
        ],
        firstxl: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '是否第一学历 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '是否第一学历 值不能为空', trigger: 'blur' },
        ],
        endtime: [
             { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '毕业时间（*） 值不能为空', trigger: 'change' },
            { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '毕业时间（*） 值不能为空', trigger: 'blur' },
        ],
        schoolname: [
             { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '毕业院校（*） 值不能为空', trigger: 'change' },
            { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '毕业院校（*） 值不能为空', trigger: 'blur' },
        ],
        starttime: [
             { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '入学时间（*） 值不能为空', trigger: 'change' },
            { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '入学时间（*） 值不能为空', trigger: 'blur' },
        ],
        xkml: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '一级学科（*） 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '一级学科（*） 值不能为空', trigger: 'blur' },
        ],
        xl: [
             { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学历（*） 值不能为空', trigger: 'change' },
            { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学历（*） 值不能为空', trigger: 'blur' },
        ],
        higestxl: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '是否最高学历 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '是否最高学历 值不能为空', trigger: 'blur' },
        ],
        formsoflearning: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学习形式 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学习形式 值不能为空', trigger: 'blur' },
        ],
        xxxz: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学校性质 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学校性质 值不能为空', trigger: 'blur' },
        ],
        xlyz: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学历验证 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '学历验证 值不能为空', trigger: 'blur' },
        ],
        majorname: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '专业名称（*） 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '专业名称（*） 值不能为空', trigger: 'blur' },
        ],
        byz: [
             { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '毕业证（*） 值不能为空', trigger: 'change' },
            { required: true, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '毕业证（*） 值不能为空', trigger: 'blur' },
        ],
        pcmprofileid: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '应聘者ID 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '应聘者ID 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '教育背景标识 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '教育背景标识 值不能为空', trigger: 'blur' },
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    public load(opt: any = {}, pageReset: boolean = false): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PCMEducationExperienceJYBJGridView视图表格fetchAction参数未配置' });
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
     * @memberof Main
     */
    public async remove(datas: any[]): Promise<any> {
        if(!this.removeAction){
            this.$Notice.error({ title: '错误', desc: 'PCMEducationExperienceJYBJGridView视图表格removeAction参数未配置' });
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
            let srfmajortext = record.pcmeducationexperiencename;
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
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ pcmeducationexperience: _keys }),Object.assign({ pcmeducationexperience: _keys },{viewparams:this.viewparams}), this.showBusyIndicator);
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
     * @memberof Main
     */
    public addBatch(arg: any = {}): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'PCMEducationExperienceJYBJGridView视图表格fetchAction参数未配置' });
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
     * @memberof Main
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
     * @memberof Main
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
                  filename: "教育背景表", //非必填
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
     * @memberof Main
     */
    public async formatExcelData(filterVal:any, jsonData:any) {
        let codelistColumns:Array<any> = [
          {
            name: 'xl',
            srfkey: 'EhrCodeList0117',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'xkml',
            srfkey: 'EhrCodeList0093',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'xxxz',
            srfkey: 'EhrCodeList0208',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'formsoflearning',
            srfkey: 'EhrCodeList0131',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'firstxl',
            srfkey: 'EhrCodeList0054',
            codelistType : 'STATIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'higestxl',
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof Main
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
     * @memberof Main
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof Main
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
     * @memberof Main
     */
    public getSelection(): any[] {
        return this.selections;
    }

    /**
     * 行双击事件
     *
     * @param {*} $event
     * @returns {void}
     * @memberof Main
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
     * @memberof  Main
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
     * @memberof  Main
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
     * @memberof Main
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
            return Object.is(item.pcmeducationexperience,$event.pcmeducationexperience);
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
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
    public pageRefresh(): void {
        this.load({});
    }

    /**
     * 排序变化
     *
     * @param {{ column: any, prop: any, order: any }} { column, prop, order }
     * @memberof Main
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
     * @memberof Main
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
     * @memberof Main
     */
	public uiAction(row: any, tag: any, $event: any) {
        // this.rowClick(row, true);
    }

    /**
     * 设置列状态
     *
     * @memberof Main
     */
    public setColState() {
		const _data: any = localStorage.getItem('pcmeducationexperience_main_grid');
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
     * @memberof Main
     */
    public onColChange() {
        localStorage.setItem('pcmeducationexperience_main_grid', JSON.stringify(this.allColumns));
    }

    /**
     * 获取列状态
     *
     * @param {string} name
     * @returns {boolean}
     * @memberof Main
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
     * @memberof Main
     */
    get adaptiveState(): boolean {
        return !this.allColumns.find((column: any) => column.show && Object.is(column.util, 'STAR'));
    }

    /**
     * 保存
     *
     * @param {*} $event
     * @returns {Promise<any>}
     * @memberof Main
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
                        this.$Notice.error({ title: '错误', desc: 'PCMEducationExperienceJYBJGridView视图表格createAction参数未配置' });
                    }else{
                      Object.assign(item,{viewparams:this.viewparams});
                      let response = await this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                      successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }else if(Object.is(item.rowDataState, 'update')){
                    if(!this.updateAction){
                        this.$Notice.error({ title: '错误', desc: 'PCMEducationExperienceJYBJGridView视图表格updateAction参数未配置' });
                    }else{
                        Object.assign(item,{viewparams:this.viewparams});
                        if(item.pcmeducationexperience){
                            Object.assign(this.context,{pcmeducationexperience:item.pcmeducationexperience});
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
     * @memberof Main
     */
    public newRow(args: any[], params?: any, $event?: any, xData?: any): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PCMEducationExperienceJYBJGridView视图表格loaddraftAction参数未配置' });
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
     * @memberof Main
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
     * @memberof Main
     */
    public gridEditItemChange(row: any, property: string, value: any, rowIndex: number){
        row.rowDataState = row.rowDataState ? row.rowDataState : "update" ;
        this.validate(property,row,rowIndex);
        if(Object.is(property, 'endtime')){
            const details: string[] = ['endtime', 'starttime'];
            this.updateGridEditItem('CheckTime', row, details, true);
        }
        if(Object.is(property, 'starttime')){
            const details: string[] = ['endtime', 'starttime'];
            this.updateGridEditItem('CheckTime', row, details, true);
        }
    }

    /**
     * 表格编辑项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof Main
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
     * @memberof Main
     */
    public getRowClassName(args:{row: any,rowIndex: number}){
        let isSelected = this.selections.some((item:any)=>{
            return Object.is(item.pcmeducationexperience,args.row.pcmeducationexperience);
        });
        return isSelected ? "grid-selected-row" : "";
    }
}
</script>

<style lang='less'>
@import './main-grid.less';
</style>