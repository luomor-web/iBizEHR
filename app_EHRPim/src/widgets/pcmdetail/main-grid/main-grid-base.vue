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
            <template v-if="getColumnState('zzdzs')">
                <el-table-column show-overflow-tooltip :prop="'zzdzs'" :label="$t('entities.pcmdetail.main_grid.columns.zzdzs')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zzdzs')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.zzdzs}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('shortname')">
                <el-table-column show-overflow-tooltip :prop="'shortname'" :label="$t('entities.pcmdetail.main_grid.columns.shortname')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.shortname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.shortname}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ygbh')">
                <el-table-column show-overflow-tooltip :prop="'ygbh'" :label="$t('entities.pcmdetail.main_grid.columns.ygbh')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.ygbh')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.ygbh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pimpersonname')">
                <el-table-column show-overflow-tooltip :prop="'pimpersonname'" :label="$t('entities.pcmdetail.main_grid.columns.pimpersonname')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.pimpersonname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.pimpersonname}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xb')">
                <el-table-column show-overflow-tooltip :prop="'xb'" :label="$t('entities.pcmdetail.main_grid.columns.xb')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.xb')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_XB' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.xb" tag='PIMCL_XB' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('mz')">
                <el-table-column show-overflow-tooltip :prop="'mz'" :label="$t('entities.pcmdetail.main_grid.columns.mz')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.mz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_NATION' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.mz" tag='PIMCL_NATION' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('csrq')">
                <el-table-column show-overflow-tooltip :prop="'csrq'" :label="$t('entities.pcmdetail.main_grid.columns.csrq')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.csrq')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.csrq"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('nj')">
                <el-table-column show-overflow-tooltip :prop="'nj'" :label="$t('entities.pcmdetail.main_grid.columns.nj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.nj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.nj}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('hyzk')">
                <el-table-column show-overflow-tooltip :prop="'hyzk'" :label="$t('entities.pcmdetail.main_grid.columns.hyzk')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.hyzk')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_HY' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.hyzk" tag='PIMCL_HY' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('jg')">
                <el-table-column show-overflow-tooltip :prop="'jg'" :label="$t('entities.pcmdetail.main_grid.columns.jg')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.jg')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.jg}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zzmm')">
                <el-table-column show-overflow-tooltip :prop="'zzmm'" :label="$t('entities.pcmdetail.main_grid.columns.zzmm')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zzmm')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_ZZMM' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.zzmm" tag='PIMCL_ZZMM' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('rdsj')">
                <el-table-column show-overflow-tooltip :prop="'rdsj'" :label="$t('entities.pcmdetail.main_grid.columns.rdsj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.rdsj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.rdsj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zjhm')">
                <el-table-column show-overflow-tooltip :prop="'zjhm'" :label="$t('entities.pcmdetail.main_grid.columns.zjhm')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zjhm')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.zjhm}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('hkxz')">
                <el-table-column show-overflow-tooltip :prop="'hkxz'" :label="$t('entities.pcmdetail.main_grid.columns.hkxz')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.hkxz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_HKLX' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.hkxz" tag='PIMCL_HKLX' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('hjdz')">
                <el-table-column show-overflow-tooltip :prop="'hjdz'" :label="$t('entities.pcmdetail.main_grid.columns.hjdz')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.hjdz')}}
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
                                <app-span name='hjdz' editorType="TEXTBOX" :value="row.hjdz"></app-span>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('sbcjd')">
                <el-table-column show-overflow-tooltip :prop="'sbcjd'" :label="$t('entities.pcmdetail.main_grid.columns.sbcjd')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.sbcjd')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.sbcjd}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('dyxl')">
                <el-table-column show-overflow-tooltip :prop="'dyxl'" :label="$t('entities.pcmdetail.main_grid.columns.dyxl')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.dyxl')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIM_XL2' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.dyxl" tag='PIM_XL2' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xxlb1')">
                <el-table-column show-overflow-tooltip :prop="'xxlb1'" :label="$t('entities.pcmdetail.main_grid.columns.xxlb1')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.xxlb1')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_XXXZ' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.xxlb1" tag='PIMCL_XXXZ' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xllx1')">
                <el-table-column show-overflow-tooltip :prop="'xllx1'" :label="$t('entities.pcmdetail.main_grid.columns.xllx1')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.xllx1')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_XL' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.xllx1" tag='PIMCL_XL' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('dyxlsxzy')">
                <el-table-column show-overflow-tooltip :prop="'dyxlsxzy'" :label="$t('entities.pcmdetail.main_grid.columns.dyxlsxzy')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.dyxlsxzy')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.dyxlsxzy}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('dyxljssj')">
                <el-table-column show-overflow-tooltip :prop="'dyxljssj'" :label="$t('entities.pcmdetail.main_grid.columns.dyxljssj')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.dyxljssj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.dyxljssj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('dyxlbyyx')">
                <el-table-column show-overflow-tooltip :prop="'dyxlbyyx'" :label="$t('entities.pcmdetail.main_grid.columns.dyxlbyyx')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.dyxlbyyx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.dyxlbyyx}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zgxlbyyx')">
                <el-table-column show-overflow-tooltip :prop="'zgxlbyyx'" :label="$t('entities.pcmdetail.main_grid.columns.zgxlbyyx')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zgxlbyyx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.zgxlbyyx}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zgxl')">
                <el-table-column show-overflow-tooltip :prop="'zgxl'" :label="$t('entities.pcmdetail.main_grid.columns.zgxl')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zgxl')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIM_XL2' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.zgxl" tag='PIM_XL2' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zgxxlb')">
                <el-table-column show-overflow-tooltip :prop="'zgxxlb'" :label="$t('entities.pcmdetail.main_grid.columns.zgxxlb')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zgxxlb')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_XXXZ' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.zgxxlb" tag='PIMCL_XXXZ' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zgxllx')">
                <el-table-column show-overflow-tooltip :prop="'zgxllx'" :label="$t('entities.pcmdetail.main_grid.columns.zgxllx')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zgxllx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_XL' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.zgxllx" tag='PIMCL_XL' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zgxljssj')">
                <el-table-column show-overflow-tooltip :prop="'zgxljssj'" :label="$t('entities.pcmdetail.main_grid.columns.zgxljssj')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zgxljssj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.zgxljssj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zgxlsxzy')">
                <el-table-column show-overflow-tooltip :prop="'zgxlsxzy'" :label="$t('entities.pcmdetail.main_grid.columns.zgxlsxzy')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zgxlsxzy')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.zgxlsxzy}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('cjgzsj')">
                <el-table-column show-overflow-tooltip :prop="'cjgzsj'" :label="$t('entities.pcmdetail.main_grid.columns.cjgzsj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.cjgzsj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.cjgzsj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('gznx')">
                <el-table-column show-overflow-tooltip :prop="'gznx'" :label="$t('entities.pcmdetail.main_grid.columns.gznx')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.gznx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="DECIMAL" precision="0" :data="row.gznx"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('tozjdate')">
                <el-table-column show-overflow-tooltip :prop="'tozjdate'" :label="$t('entities.pcmdetail.main_grid.columns.tozjdate')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.tozjdate')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.tozjdate"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zjxtgznx')">
                <el-table-column show-overflow-tooltip :prop="'zjxtgznx'" :label="$t('entities.pcmdetail.main_grid.columns.zjxtgznx')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zjxtgznx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="DECIMAL" precision="0" :data="row.zjxtgznx"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('dzjbjsj')">
                <el-table-column show-overflow-tooltip :prop="'dzjbjsj'" :label="$t('entities.pcmdetail.main_grid.columns.dzjbjsj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.dzjbjsj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.dzjbjsj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('bjgznx')">
                <el-table-column show-overflow-tooltip :prop="'bjgznx'" :label="$t('entities.pcmdetail.main_grid.columns.bjgznx')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.bjgznx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="DECIMAL" precision="0" :data="row.bjgznx"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('dbdwsj')">
                <el-table-column show-overflow-tooltip :prop="'dbdwsj'" :label="$t('entities.pcmdetail.main_grid.columns.dbdwsj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.dbdwsj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.dbdwsj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('bdwgznx')">
                <el-table-column show-overflow-tooltip :prop="'bdwgznx'" :label="$t('entities.pcmdetail.main_grid.columns.bdwgznx')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.bdwgznx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="DECIMAL" precision="0" :data="row.bdwgznx"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pimmajorsetypename')">
                <el-table-column show-overflow-tooltip :prop="'pimmajorsetypename'" :label="$t('entities.pcmdetail.main_grid.columns.pimmajorsetypename')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.pimmajorsetypename')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.pimmajorsetypename}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('rank')">
                <el-table-column show-overflow-tooltip :prop="'rank'" :label="$t('entities.pcmdetail.main_grid.columns.rank')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.rank')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_RANK' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.rank" tag='PIMCL_RANK' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zw')">
                <el-table-column show-overflow-tooltip :prop="'zw'" :label="$t('entities.pcmdetail.main_grid.columns.zw')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zw')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='ORMCL_ZW' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.zw" tag='ORMCL_ZW' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('gw')">
                <el-table-column show-overflow-tooltip :prop="'gw'" :label="$t('entities.pcmdetail.main_grid.columns.gw')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.gw')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.gw}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('gwtype')">
                <el-table-column show-overflow-tooltip :prop="'gwtype'" :label="$t('entities.pcmdetail.main_grid.columns.gwtype')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.gwtype')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='ORMCL_GWTYPE' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.gwtype" tag='ORMCL_GWTYPE' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('jxkhcj')">
                <el-table-column show-overflow-tooltip :prop="'jxkhcj'" :label="$t('entities.pcmdetail.main_grid.columns.jxkhcj')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.jxkhcj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.jxkhcj}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pimqualtypename')">
                <el-table-column show-overflow-tooltip :prop="'pimqualtypename'" :label="$t('entities.pcmdetail.main_grid.columns.pimqualtypename')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.pimqualtypename')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.pimqualtypename}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('careername')">
                <el-table-column show-overflow-tooltip :prop="'careername'" :label="$t('entities.pcmdetail.main_grid.columns.careername')" :width="180"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.careername')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.careername}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zcbh')">
                <el-table-column show-overflow-tooltip :prop="'zcbh'" :label="$t('entities.pcmdetail.main_grid.columns.zcbh')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zcbh')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.zcbh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('sfzckjs')">
                <el-table-column show-overflow-tooltip :prop="'sfzckjs'" :label="$t('entities.pcmdetail.main_grid.columns.sfzckjs')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.sfzckjs')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" style="width: 100px;" tag='YesNo' codelistType='STATIC' placeholder='请选择...' @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.sfzckjs" tag='YesNo' codelistType='STATIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zgzsbh')">
                <el-table-column show-overflow-tooltip :prop="'zgzsbh'" :label="$t('entities.pcmdetail.main_grid.columns.zgzsbh')" :width="170"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.zgzsbh')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.zgzsbh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pimvocationalcatalogname')">
                <el-table-column show-overflow-tooltip :prop="'pimvocationalcatalogname'" :label="$t('entities.pcmdetail.main_grid.columns.pimvocationalcatalogname')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.pimvocationalcatalogname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.pimvocationalcatalogname}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('rzqd')">
                <el-table-column show-overflow-tooltip :prop="'rzqd'" :label="$t('entities.pcmdetail.main_grid.columns.rzqd')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.rzqd')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_RZLB' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.rzqd" tag='PIMCL_RZLB' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('htlb')">
                <el-table-column show-overflow-tooltip :prop="'htlb'" :label="$t('entities.pcmdetail.main_grid.columns.htlb')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.htlb')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_HTLX' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.htlb" tag='PIMCL_HTLX' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('contracttype')">
                <el-table-column show-overflow-tooltip :prop="'contracttype'" :label="$t('entities.pcmdetail.main_grid.columns.contracttype')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.contracttype')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template v-if="actualIsOpenEdit">
                            <app-form-item :error="gridItemsModel[$index][column.property].error">
                                 <dropdown-list v-model="row[column.property]" :disabled="row.srfuf === 1 ? (3 & 2) !== 2 : (3 & 1) !== 1" tag='PIMCL_TYPECONTRACT' codelistType='DYNAMIC' placeholder='请选择...' style="" @change="($event)=>{gridEditItemChange(row, column.property, $event, $index)}"></dropdown-list>
                            </app-form-item>
                        </template>
                        <template v-if="!actualIsOpenEdit">
            <codelist :value="row.contracttype" tag='PIMCL_TYPECONTRACT' codelistType='DYNAMIC' ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('qsrq')">
                <el-table-column show-overflow-tooltip :prop="'qsrq'" :label="$t('entities.pcmdetail.main_grid.columns.qsrq')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.qsrq')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.qsrq"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('jsrq')">
                <el-table-column show-overflow-tooltip :prop="'jsrq'" :label="$t('entities.pcmdetail.main_grid.columns.jsrq')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.jsrq')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.jsrq"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('htsyq')">
                <el-table-column show-overflow-tooltip :prop="'htsyq'" :label="$t('entities.pcmdetail.main_grid.columns.htsyq')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.htsyq')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.htsyq}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('htqx')">
                <el-table-column show-overflow-tooltip :prop="'htqx'" :label="$t('entities.pcmdetail.main_grid.columns.htqx')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.htqx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <app-format-data format="YYYY-MM-DD" :data="row.htqx"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('lxdh')">
                <el-table-column show-overflow-tooltip :prop="'lxdh'" :label="$t('entities.pcmdetail.main_grid.columns.lxdh')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.lxdh')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.lxdh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('yglx')">
                <el-table-column show-overflow-tooltip :prop="'yglx'" :label="$t('entities.pcmdetail.main_grid.columns.yglx')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.pcmdetail.main_grid.columns.yglx')}}
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
            <codelist :value="row.yglx" tag='PIMCL_YGLX' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
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
import PCMDETAILService from '@/service/pcmdetail/pcmdetail-service';
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
     * @type {PCMDETAILService}
     * @memberof Main
     */
    public appEntityService: PCMDETAILService = new PCMDETAILService({ $store: this.$store });
    


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
    public isEnablePagingBar: boolean = true;

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
    public minorSortDir: string = '';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof Main
     */
    public minorSortPSDEF: string = '';

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof Main
     */
    public limit: number = 100;

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
            name: 'zzdzs',
            label: '工作单位',
            langtag: 'entities.pcmdetail.main_grid.columns.zzdzs',
            show: true,
            util: 'PX'
        },
        {
            name: 'shortname',
            label: '部门名称',
            langtag: 'entities.pcmdetail.main_grid.columns.shortname',
            show: true,
            util: 'PX'
        },
        {
            name: 'ygbh',
            label: '员工编号',
            langtag: 'entities.pcmdetail.main_grid.columns.ygbh',
            show: true,
            util: 'px'
        },
        {
            name: 'pimpersonname',
            label: '员工姓名',
            langtag: 'entities.pcmdetail.main_grid.columns.pimpersonname',
            show: true,
            util: 'px'
        },
        {
            name: 'xb',
            label: '性别',
            langtag: 'entities.pcmdetail.main_grid.columns.xb',
            show: true,
            util: 'PX'
        },
        {
            name: 'mz',
            label: '民族',
            langtag: 'entities.pcmdetail.main_grid.columns.mz',
            show: true,
            util: 'PX'
        },
        {
            name: 'csrq',
            label: '出生日期',
            langtag: 'entities.pcmdetail.main_grid.columns.csrq',
            show: true,
            util: 'px'
        },
        {
            name: 'nj',
            label: '年龄',
            langtag: 'entities.pcmdetail.main_grid.columns.nj',
            show: true,
            util: 'px'
        },
        {
            name: 'hyzk',
            label: '婚姻状况',
            langtag: 'entities.pcmdetail.main_grid.columns.hyzk',
            show: true,
            util: 'PX'
        },
        {
            name: 'jg',
            label: '籍贯',
            langtag: 'entities.pcmdetail.main_grid.columns.jg',
            show: true,
            util: 'px'
        },
        {
            name: 'zzmm',
            label: '政治面貌',
            langtag: 'entities.pcmdetail.main_grid.columns.zzmm',
            show: true,
            util: 'PX'
        },
        {
            name: 'rdsj',
            label: '入党时间',
            langtag: 'entities.pcmdetail.main_grid.columns.rdsj',
            show: true,
            util: 'px'
        },
        {
            name: 'zjhm',
            label: '证件号码',
            langtag: 'entities.pcmdetail.main_grid.columns.zjhm',
            show: true,
            util: 'px'
        },
        {
            name: 'hkxz',
            label: '户口性质',
            langtag: 'entities.pcmdetail.main_grid.columns.hkxz',
            show: true,
            util: 'PX'
        },
        {
            name: 'hjdz',
            label: '户籍地址',
            langtag: 'entities.pcmdetail.main_grid.columns.hjdz',
            show: true,
            util: 'PX'
        },
        {
            name: 'sbcjd',
            label: '社保参缴地',
            langtag: 'entities.pcmdetail.main_grid.columns.sbcjd',
            show: true,
            util: 'px'
        },
        {
            name: 'dyxl',
            label: '第一学历',
            langtag: 'entities.pcmdetail.main_grid.columns.dyxl',
            show: true,
            util: 'PX'
        },
        {
            name: 'xxlb1',
            label: '第一学历学校类别',
            langtag: 'entities.pcmdetail.main_grid.columns.xxlb1',
            show: true,
            util: 'PX'
        },
        {
            name: 'xllx1',
            label: '第一学历学习形式',
            langtag: 'entities.pcmdetail.main_grid.columns.xllx1',
            show: true,
            util: 'PX'
        },
        {
            name: 'dyxlsxzy',
            label: '第一学历所学专业',
            langtag: 'entities.pcmdetail.main_grid.columns.dyxlsxzy',
            show: true,
            util: 'PX'
        },
        {
            name: 'dyxljssj',
            label: '第一学历毕业时间',
            langtag: 'entities.pcmdetail.main_grid.columns.dyxljssj',
            show: true,
            util: 'PX'
        },
        {
            name: 'dyxlbyyx',
            label: '第一学历毕业院校',
            langtag: 'entities.pcmdetail.main_grid.columns.dyxlbyyx',
            show: true,
            util: 'PX'
        },
        {
            name: 'zgxlbyyx',
            label: '最高学历毕业院校',
            langtag: 'entities.pcmdetail.main_grid.columns.zgxlbyyx',
            show: true,
            util: 'PX'
        },
        {
            name: 'zgxl',
            label: '最高学历',
            langtag: 'entities.pcmdetail.main_grid.columns.zgxl',
            show: true,
            util: 'PX'
        },
        {
            name: 'zgxxlb',
            label: '最高学历学校类别',
            langtag: 'entities.pcmdetail.main_grid.columns.zgxxlb',
            show: true,
            util: 'PX'
        },
        {
            name: 'zgxllx',
            label: '最高学历学习形式',
            langtag: 'entities.pcmdetail.main_grid.columns.zgxllx',
            show: true,
            util: 'PX'
        },
        {
            name: 'zgxljssj',
            label: '最高学历毕业时间',
            langtag: 'entities.pcmdetail.main_grid.columns.zgxljssj',
            show: true,
            util: 'PX'
        },
        {
            name: 'zgxlsxzy',
            label: '最高学历所学专业',
            langtag: 'entities.pcmdetail.main_grid.columns.zgxlsxzy',
            show: true,
            util: 'PX'
        },
        {
            name: 'cjgzsj',
            label: '参加工作时间',
            langtag: 'entities.pcmdetail.main_grid.columns.cjgzsj',
            show: true,
            util: 'px'
        },
        {
            name: 'gznx',
            label: '工作年限',
            langtag: 'entities.pcmdetail.main_grid.columns.gznx',
            show: true,
            util: 'px'
        },
        {
            name: 'tozjdate',
            label: '建筑系统工作时间',
            langtag: 'entities.pcmdetail.main_grid.columns.tozjdate',
            show: true,
            util: 'PX'
        },
        {
            name: 'zjxtgznx',
            label: '建筑系统工作年限',
            langtag: 'entities.pcmdetail.main_grid.columns.zjxtgznx',
            show: true,
            util: 'PX'
        },
        {
            name: 'dzjbjsj',
            label: '局工作时间',
            langtag: 'entities.pcmdetail.main_grid.columns.dzjbjsj',
            show: true,
            util: 'px'
        },
        {
            name: 'bjgznx',
            label: '局工作年限',
            langtag: 'entities.pcmdetail.main_grid.columns.bjgznx',
            show: true,
            util: 'px'
        },
        {
            name: 'dbdwsj',
            label: '本单位工作时间',
            langtag: 'entities.pcmdetail.main_grid.columns.dbdwsj',
            show: true,
            util: 'px'
        },
        {
            name: 'bdwgznx',
            label: '本单位工作年限',
            langtag: 'entities.pcmdetail.main_grid.columns.bdwgznx',
            show: true,
            util: 'px'
        },
        {
            name: 'pimmajorsetypename',
            label: '所属业务系统',
            langtag: 'entities.pcmdetail.main_grid.columns.pimmajorsetypename',
            show: true,
            util: 'px'
        },
        {
            name: 'rank',
            label: '职级',
            langtag: 'entities.pcmdetail.main_grid.columns.rank',
            show: true,
            util: 'PX'
        },
        {
            name: 'zw',
            label: '职务',
            langtag: 'entities.pcmdetail.main_grid.columns.zw',
            show: true,
            util: 'PX'
        },
        {
            name: 'gw',
            label: '岗位',
            langtag: 'entities.pcmdetail.main_grid.columns.gw',
            show: true,
            util: 'PX'
        },
        {
            name: 'gwtype',
            label: '岗位类别',
            langtag: 'entities.pcmdetail.main_grid.columns.gwtype',
            show: true,
            util: 'PX'
        },
        {
            name: 'jxkhcj',
            label: '绩效考核成绩（近两年）',
            langtag: 'entities.pcmdetail.main_grid.columns.jxkhcj',
            show: true,
            util: 'PX'
        },
        {
            name: 'pimqualtypename',
            label: '岗位证书',
            langtag: 'entities.pcmdetail.main_grid.columns.pimqualtypename',
            show: true,
            util: 'px'
        },
        {
            name: 'careername',
            label: '专业技术资格（职称）',
            langtag: 'entities.pcmdetail.main_grid.columns.careername',
            show: true,
            util: 'PX'
        },
        {
            name: 'zcbh',
            label: '职称编号',
            langtag: 'entities.pcmdetail.main_grid.columns.zcbh',
            show: true,
            util: 'px'
        },
        {
            name: 'sfzckjs',
            label: '是否注册会计师',
            langtag: 'entities.pcmdetail.main_grid.columns.sfzckjs',
            show: true,
            util: 'PX'
        },
        {
            name: 'zgzsbh',
            label: '注册会计师证书编号',
            langtag: 'entities.pcmdetail.main_grid.columns.zgzsbh',
            show: true,
            util: 'PX'
        },
        {
            name: 'pimvocationalcatalogname',
            label: '执(职)业资格证书',
            langtag: 'entities.pcmdetail.main_grid.columns.pimvocationalcatalogname',
            show: true,
            util: 'px'
        },
        {
            name: 'rzqd',
            label: '入职渠道',
            langtag: 'entities.pcmdetail.main_grid.columns.rzqd',
            show: true,
            util: 'PX'
        },
        {
            name: 'htlb',
            label: '合同类别',
            langtag: 'entities.pcmdetail.main_grid.columns.htlb',
            show: true,
            util: 'PX'
        },
        {
            name: 'contracttype',
            label: '劳动合同性质',
            langtag: 'entities.pcmdetail.main_grid.columns.contracttype',
            show: true,
            util: 'PX'
        },
        {
            name: 'qsrq',
            label: '签订日期',
            langtag: 'entities.pcmdetail.main_grid.columns.qsrq',
            show: true,
            util: 'px'
        },
        {
            name: 'jsrq',
            label: '结束日期',
            langtag: 'entities.pcmdetail.main_grid.columns.jsrq',
            show: true,
            util: 'px'
        },
        {
            name: 'htsyq',
            label: '合同试用期',
            langtag: 'entities.pcmdetail.main_grid.columns.htsyq',
            show: true,
            util: 'px'
        },
        {
            name: 'htqx',
            label: '合同期限',
            langtag: 'entities.pcmdetail.main_grid.columns.htqx',
            show: true,
            util: 'px'
        },
        {
            name: 'lxdh',
            label: '联系方式',
            langtag: 'entities.pcmdetail.main_grid.columns.lxdh',
            show: true,
            util: 'px'
        },
        {
            name: 'yglx',
            label: '员工类型',
            langtag: 'entities.pcmdetail.main_grid.columns.yglx',
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
          rzqd: new FormItemModel(),
          sfzckjs: new FormItemModel(),
          hkxz: new FormItemModel(),
          dyxl: new FormItemModel(),
          zgxxlb: new FormItemModel(),
          xxlb1: new FormItemModel(),
          mz: new FormItemModel(),
          srfkey: new FormItemModel(),
          zgxl: new FormItemModel(),
          xxlb: new FormItemModel(),
          zw: new FormItemModel(),
          hjdz: new FormItemModel(),
          htlb: new FormItemModel(),
          rank: new FormItemModel(),
          contracttype: new FormItemModel(),
          gwtype: new FormItemModel(),
          xllx: new FormItemModel(),
          xb: new FormItemModel(),
          xllx1: new FormItemModel(),
          yglx: new FormItemModel(),
          zgxllx: new FormItemModel(),
          zzmm: new FormItemModel(),
          hyzk: new FormItemModel(),
        }
    }

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof Main
     */
    public rules: any = {
        rzqd: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '入职渠道 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '入职渠道 值不能为空', trigger: 'blur' },
        ],
        sfzckjs: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '是否注册会计师 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '是否注册会计师 值不能为空', trigger: 'blur' },
        ],
        hkxz: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '户口性质 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '户口性质 值不能为空', trigger: 'blur' },
        ],
        dyxl: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '第一学历 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '第一学历 值不能为空', trigger: 'blur' },
        ],
        zgxxlb: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '最高学历学校类别 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '最高学历学校类别 值不能为空', trigger: 'blur' },
        ],
        xxlb1: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '第一学历学校类别 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '第一学历学校类别 值不能为空', trigger: 'blur' },
        ],
        mz: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '民族 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '民族 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '人员明细表标识 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '人员明细表标识 值不能为空', trigger: 'blur' },
        ],
        zgxl: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '最高学历 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '最高学历 值不能为空', trigger: 'blur' },
        ],
        xxlb: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '值不能为空', trigger: 'blur' },
        ],
        zw: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '职务 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '职务 值不能为空', trigger: 'blur' },
        ],
        hjdz: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '户籍地址 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '户籍地址 值不能为空', trigger: 'blur' },
        ],
        htlb: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '合同类别 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '合同类别 值不能为空', trigger: 'blur' },
        ],
        rank: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '职级 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '职级 值不能为空', trigger: 'blur' },
        ],
        contracttype: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '劳动合同性质 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '劳动合同性质 值不能为空', trigger: 'blur' },
        ],
        gwtype: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '岗位类别 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '岗位类别 值不能为空', trigger: 'blur' },
        ],
        xllx: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '值不能为空', trigger: 'blur' },
        ],
        xb: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '性别 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '性别 值不能为空', trigger: 'blur' },
        ],
        xllx1: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '第一学历学习形式 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '第一学历学习形式 值不能为空', trigger: 'blur' },
        ],
        yglx: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '员工类型 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '员工类型 值不能为空', trigger: 'blur' },
        ],
        zgxllx: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '最高学历学习形式 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '最高学历学习形式 值不能为空', trigger: 'blur' },
        ],
        zzmm: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '政治面貌 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '政治面貌 值不能为空', trigger: 'blur' },
        ],
        hyzk: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '婚姻状况 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '婚姻状况 值不能为空', trigger: 'blur' },
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
            this.$Notice.error({ title: '错误', desc: 'PCMDETAILGridView视图表格fetchAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'PCMDETAILGridView视图表格removeAction参数未配置' });
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
            let srfmajortext = record.pcmdetailname;
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
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ pcmdetail: _keys }),Object.assign({ pcmdetail: _keys },{viewparams:this.viewparams}), this.showBusyIndicator);
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
            this.$Notice.error({ title: '错误', desc: 'PCMDETAILGridView视图表格fetchAction参数未配置' });
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
                  filename: "人员明细表表", //非必填
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
            name: 'xb',
            srfkey: 'PIMCL_XB',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'mz',
            srfkey: 'PIMCL_NATION',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'hyzk',
            srfkey: 'PIMCL_HY',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'zzmm',
            srfkey: 'PIMCL_ZZMM',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'hkxz',
            srfkey: 'PIMCL_HKLX',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'dyxl',
            srfkey: 'PIM_XL2',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'xxlb1',
            srfkey: 'PIMCL_XXXZ',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'xllx1',
            srfkey: 'PIMCL_XL',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'zgxl',
            srfkey: 'PIM_XL2',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'zgxxlb',
            srfkey: 'PIMCL_XXXZ',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'zgxllx',
            srfkey: 'PIMCL_XL',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'rank',
            srfkey: 'PIMCL_RANK',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'zw',
            srfkey: 'ORMCL_ZW',
            codelistType : 'DYNAMIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'gwtype',
            srfkey: 'ORMCL_GWTYPE',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'sfzckjs',
            srfkey: 'YesNo',
            codelistType : 'STATIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'rzqd',
            srfkey: 'PIMCL_RZLB',
            codelistType : 'DYNAMIC',
            renderMode: 'other',
            textSeparator: '、',
            valueSeparator: ',',
          },
          {
            name: 'htlb',
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
            valueSeparator: ',',
          },
          {
            name: 'yglx',
            srfkey: 'PIMCL_YGLX',
            codelistType : 'DYNAMIC',
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
            return Object.is(item.pcmdetail,$event.pcmdetail);
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
		const _data: any = localStorage.getItem('pcmdetail_main_grid');
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
        localStorage.setItem('pcmdetail_main_grid', JSON.stringify(this.allColumns));
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
                        this.$Notice.error({ title: '错误', desc: 'PCMDETAILGridView视图表格createAction参数未配置' });
                    }else{
                      Object.assign(item,{viewparams:this.viewparams});
                      let response = await this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                      successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }else if(Object.is(item.rowDataState, 'update')){
                    if(!this.updateAction){
                        this.$Notice.error({ title: '错误', desc: 'PCMDETAILGridView视图表格updateAction参数未配置' });
                    }else{
                        Object.assign(item,{viewparams:this.viewparams});
                        if(item.pcmdetail){
                            Object.assign(this.context,{pcmdetail:item.pcmdetail});
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
            this.$Notice.error({ title: '错误', desc: 'PCMDETAILGridView视图表格loaddraftAction参数未配置' });
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
            return Object.is(item.pcmdetail,args.row.pcmdetail);
        });
        return isSelected ? "grid-selected-row" : "";
    }
}
</script>

<style lang='less'>
@import './main-grid.less';
</style>