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
            <template v-if="getColumnState('nd')">
                <el-table-column show-overflow-tooltip :prop="'nd'" :label="$t('entities.attensummary.main_grid.columns.nd')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.nd')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.nd" tag='EhrCodeList0115' codelistType='STATIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('yf')">
                <el-table-column show-overflow-tooltip :prop="'yf'" :label="$t('entities.attensummary.main_grid.columns.yf')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.yf')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.yf" tag='CodeList82' codelistType='STATIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pimpersonname')">
                <el-table-column show-overflow-tooltip :prop="'pimpersonname'" :label="$t('entities.attensummary.main_grid.columns.pimpersonname')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.pimpersonname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.pimpersonname}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ygbh')">
                <el-table-column show-overflow-tooltip :prop="'ygbh'" :label="$t('entities.attensummary.main_grid.columns.ygbh')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.ygbh')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.ygbh}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ormorgname')">
                <el-table-column show-overflow-tooltip :prop="'ormorgname'" :label="$t('entities.attensummary.main_grid.columns.ormorgname')" :width="200"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.ormorgname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.ormorgname}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ormorgsectorname')">
                <el-table-column show-overflow-tooltip :prop="'ormorgsectorname'" :label="$t('entities.attensummary.main_grid.columns.ormorgsectorname')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.ormorgsectorname')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.ormorgsectorname}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zw')">
                <el-table-column show-overflow-tooltip :prop="'zw'" :label="$t('entities.attensummary.main_grid.columns.zw')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.zw')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <template >
            <codelist :value="row.zw" tag='EhrCodeList0233' codelistType='DYNAMIC' renderMode="STR" valueSeparator=";" textSeparator="、" ></codelist>
                        </template>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('sdt')">
                <el-table-column show-overflow-tooltip :prop="'sdt'" :label="$t('entities.attensummary.main_grid.columns.sdt')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.sdt')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.sdt"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('cdf')">
                <el-table-column show-overflow-tooltip :prop="'cdf'" :label="$t('entities.attensummary.main_grid.columns.cdf')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.cdf')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.cdf"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('cdc')">
                <el-table-column show-overflow-tooltip :prop="'cdc'" :label="$t('entities.attensummary.main_grid.columns.cdc')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.cdc')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.cdc}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ztf')">
                <el-table-column show-overflow-tooltip :prop="'ztf'" :label="$t('entities.attensummary.main_grid.columns.ztf')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.ztf')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.ztf"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('ztc')">
                <el-table-column show-overflow-tooltip :prop="'ztc'" :label="$t('entities.attensummary.main_grid.columns.ztc')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.ztc')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.ztc}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('qq')">
                <el-table-column show-overflow-tooltip :prop="'qq'" :label="$t('entities.attensummary.main_grid.columns.qq')" :width="100"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.qq')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.qq"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('cd')">
                <el-table-column show-overflow-tooltip :prop="'cd'" :label="$t('entities.attensummary.main_grid.columns.cd')" :width="100"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.cd')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.cd"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zt')">
                <el-table-column show-overflow-tooltip :prop="'zt'" :label="$t('entities.attensummary.main_grid.columns.zt')" :width="100"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.zt')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.zt"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('kg')">
                <el-table-column show-overflow-tooltip :prop="'kg'" :label="$t('entities.attensummary.main_grid.columns.kg')" :width="100"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.kg')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.kg"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('cc')">
                <el-table-column show-overflow-tooltip :prop="'cc'" :label="$t('entities.attensummary.main_grid.columns.cc')" :width="100"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.cc')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.cc"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('fdjrjb')">
                <el-table-column show-overflow-tooltip :prop="'fdjrjb'" :label="$t('entities.attensummary.main_grid.columns.fdjrjb')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.fdjrjb')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.fdjrjb"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('xxrjb')">
                <el-table-column show-overflow-tooltip :prop="'xxrjb'" :label="$t('entities.attensummary.main_grid.columns.xxrjb')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.xxrjb')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.xxrjb"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('gzrjb')">
                <el-table-column show-overflow-tooltip :prop="'gzrjb'" :label="$t('entities.attensummary.main_grid.columns.gzrjb')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.gzrjb')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.gzrjb"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('tcxx')">
                <el-table-column show-overflow-tooltip :prop="'tcxx'" :label="$t('entities.attensummary.main_grid.columns.tcxx')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.tcxx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.tcxx"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('qt')">
                <el-table-column show-overflow-tooltip :prop="'qt'" :label="$t('entities.attensummary.main_grid.columns.qt')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.qt')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.qt"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('nx')">
                <el-table-column show-overflow-tooltip :prop="'nx'" :label="$t('entities.attensummary.main_grid.columns.nx')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.nx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.nx"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('sj')">
                <el-table-column show-overflow-tooltip :prop="'sj'" :label="$t('entities.attensummary.main_grid.columns.sj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.sj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.sj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('bj')">
                <el-table-column show-overflow-tooltip :prop="'bj'" :label="$t('entities.attensummary.main_grid.columns.bj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.bj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.bj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('tx')">
                <el-table-column show-overflow-tooltip :prop="'tx'" :label="$t('entities.attensummary.main_grid.columns.tx')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.tx')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.tx"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('gs')">
                <el-table-column show-overflow-tooltip :prop="'gs'" :label="$t('entities.attensummary.main_grid.columns.gs')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.gs')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.gs"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('jh')">
                <el-table-column show-overflow-tooltip :prop="'jh'" :label="$t('entities.attensummary.main_grid.columns.jh')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.jh')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.jh"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('yq')">
                <el-table-column show-overflow-tooltip :prop="'yq'" :label="$t('entities.attensummary.main_grid.columns.yq')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.yq')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.yq"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('cj')">
                <el-table-column show-overflow-tooltip :prop="'cj'" :label="$t('entities.attensummary.main_grid.columns.cj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.cj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.cj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('pc')">
                <el-table-column show-overflow-tooltip :prop="'pc'" :label="$t('entities.attensummary.main_grid.columns.pc')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.pc')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.pc"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('br')">
                <el-table-column show-overflow-tooltip :prop="'br'" :label="$t('entities.attensummary.main_grid.columns.br')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.br')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.br"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('tq')">
                <el-table-column show-overflow-tooltip :prop="'tq'" :label="$t('entities.attensummary.main_grid.columns.tq')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.tq')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.tq"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('sz')">
                <el-table-column show-overflow-tooltip :prop="'sz'" :label="$t('entities.attensummary.main_grid.columns.sz')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.sz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.sz"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('js')">
                <el-table-column show-overflow-tooltip :prop="'js'" :label="$t('entities.attensummary.main_grid.columns.js')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.js')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.js"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('qtdxj')">
                <el-table-column show-overflow-tooltip :prop="'qtdxj'" :label="$t('entities.attensummary.main_grid.columns.qtdxj')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.qtdxj')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.qtdxj"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('wqdts')">
                <el-table-column show-overflow-tooltip :prop="'wqdts'" :label="$t('entities.attensummary.main_grid.columns.wqdts')" :width="150"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.wqdts')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.wqdts"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('zhts')">
                <el-table-column show-overflow-tooltip :prop="'zhts'" :label="$t('entities.attensummary.main_grid.columns.zhts')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.zhts')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.zhts"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('sjcqts')">
                <el-table-column show-overflow-tooltip :prop="'sjcqts'" :label="$t('entities.attensummary.main_grid.columns.sjcqts')" :width="160"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.sjcqts')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                            <app-format-data dataType="FLOAT" precision="0" :data="row.sjcqts"></app-format-data>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('remarkreason')">
                <el-table-column show-overflow-tooltip :prop="'remarkreason'" :label="$t('entities.attensummary.main_grid.columns.remarkreason')" :width="260"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.remarkreason')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.remarkreason}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('bz')">
                <el-table-column show-overflow-tooltip :prop="'bz'" :label="$t('entities.attensummary.main_grid.columns.bz')" :width="260"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.bz')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.bz}}</span>
                    </template>
                </el-table-column>
            </template>
            <template v-if="getColumnState('description')">
                <el-table-column show-overflow-tooltip :prop="'description'" :label="$t('entities.attensummary.main_grid.columns.description')" :width="260"  :align="'left'" :sortable="'custom'">
                    <template v-slot:header="{column}">
                      <span class="column-header ">
                        {{$t('entities.attensummary.main_grid.columns.description')}}
                      </span>
                    </template>
                    <template v-slot="{row,column,$index}">
                        <span>{{row.description}}</span>
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
import AttEnsummaryService from '@/service/att-ensummary/att-ensummary-service';
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
     * @type {AttEnsummaryService}
     * @memberof Main
     */
    public appEntityService: AttEnsummaryService = new AttEnsummaryService({ $store: this.$store });
    


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
    public minorSortDir: string = 'ASC';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof Main
     */
    public minorSortPSDEF: string = 'ygbh';

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
            name: 'nd',
            label: '年度',
            langtag: 'entities.attensummary.main_grid.columns.nd',
            show: true,
            util: 'PX'
        },
        {
            name: 'yf',
            label: '月份',
            langtag: 'entities.attensummary.main_grid.columns.yf',
            show: true,
            util: 'PX'
        },
        {
            name: 'pimpersonname',
            label: '员工姓名',
            langtag: 'entities.attensummary.main_grid.columns.pimpersonname',
            show: true,
            util: 'PX'
        },
        {
            name: 'ygbh',
            label: '员工编号',
            langtag: 'entities.attensummary.main_grid.columns.ygbh',
            show: true,
            util: 'PX'
        },
        {
            name: 'ormorgname',
            label: '组织名称',
            langtag: 'entities.attensummary.main_grid.columns.ormorgname',
            show: true,
            util: 'PX'
        },
        {
            name: 'ormorgsectorname',
            label: '部门/项目部',
            langtag: 'entities.attensummary.main_grid.columns.ormorgsectorname',
            show: true,
            util: 'PX'
        },
        {
            name: 'zw',
            label: '职务',
            langtag: 'entities.attensummary.main_grid.columns.zw',
            show: true,
            util: 'PX'
        },
        {
            name: 'sdt',
            label: '实到（天）',
            langtag: 'entities.attensummary.main_grid.columns.sdt',
            show: true,
            util: 'PX'
        },
        {
            name: 'cdf',
            label: '迟到（分）',
            langtag: 'entities.attensummary.main_grid.columns.cdf',
            show: true,
            util: 'PX'
        },
        {
            name: 'cdc',
            label: '迟到（次）',
            langtag: 'entities.attensummary.main_grid.columns.cdc',
            show: true,
            util: 'PX'
        },
        {
            name: 'ztf',
            label: '早退（分）',
            langtag: 'entities.attensummary.main_grid.columns.ztf',
            show: true,
            util: 'PX'
        },
        {
            name: 'ztc',
            label: '早退（次）',
            langtag: 'entities.attensummary.main_grid.columns.ztc',
            show: true,
            util: 'PX'
        },
        {
            name: 'qq',
            label: '全勤',
            langtag: 'entities.attensummary.main_grid.columns.qq',
            show: true,
            util: 'PX'
        },
        {
            name: 'cd',
            label: '迟到',
            langtag: 'entities.attensummary.main_grid.columns.cd',
            show: true,
            util: 'PX'
        },
        {
            name: 'zt',
            label: '早退',
            langtag: 'entities.attensummary.main_grid.columns.zt',
            show: true,
            util: 'PX'
        },
        {
            name: 'kg',
            label: '旷工',
            langtag: 'entities.attensummary.main_grid.columns.kg',
            show: true,
            util: 'PX'
        },
        {
            name: 'cc',
            label: '出差',
            langtag: 'entities.attensummary.main_grid.columns.cc',
            show: true,
            util: 'PX'
        },
        {
            name: 'fdjrjb',
            label: '法定假日加班',
            langtag: 'entities.attensummary.main_grid.columns.fdjrjb',
            show: true,
            util: 'PX'
        },
        {
            name: 'xxrjb',
            label: '休息日加班',
            langtag: 'entities.attensummary.main_grid.columns.xxrjb',
            show: true,
            util: 'PX'
        },
        {
            name: 'gzrjb',
            label: '工作日加班',
            langtag: 'entities.attensummary.main_grid.columns.gzrjb',
            show: true,
            util: 'PX'
        },
        {
            name: 'tcxx',
            label: '脱产学习',
            langtag: 'entities.attensummary.main_grid.columns.tcxx',
            show: true,
            util: 'PX'
        },
        {
            name: 'qt',
            label: '其他',
            langtag: 'entities.attensummary.main_grid.columns.qt',
            show: true,
            util: 'PX'
        },
        {
            name: 'nx',
            label: '年休假',
            langtag: 'entities.attensummary.main_grid.columns.nx',
            show: true,
            util: 'PX'
        },
        {
            name: 'sj',
            label: '事假',
            langtag: 'entities.attensummary.main_grid.columns.sj',
            show: true,
            util: 'PX'
        },
        {
            name: 'bj',
            label: '病假',
            langtag: 'entities.attensummary.main_grid.columns.bj',
            show: true,
            util: 'PX'
        },
        {
            name: 'tx',
            label: '调休假',
            langtag: 'entities.attensummary.main_grid.columns.tx',
            show: true,
            util: 'PX'
        },
        {
            name: 'gs',
            label: '工伤假',
            langtag: 'entities.attensummary.main_grid.columns.gs',
            show: true,
            util: 'PX'
        },
        {
            name: 'jh',
            label: '结婚假',
            langtag: 'entities.attensummary.main_grid.columns.jh',
            show: true,
            util: 'PX'
        },
        {
            name: 'yq',
            label: '孕期假',
            langtag: 'entities.attensummary.main_grid.columns.yq',
            show: true,
            util: 'PX'
        },
        {
            name: 'cj',
            label: '产假',
            langtag: 'entities.attensummary.main_grid.columns.cj',
            show: true,
            util: 'PX'
        },
        {
            name: 'pc',
            label: '陪产假',
            langtag: 'entities.attensummary.main_grid.columns.pc',
            show: true,
            util: 'PX'
        },
        {
            name: 'br',
            label: '哺乳假',
            langtag: 'entities.attensummary.main_grid.columns.br',
            show: true,
            util: 'PX'
        },
        {
            name: 'tq',
            label: '探亲假',
            langtag: 'entities.attensummary.main_grid.columns.tq',
            show: true,
            util: 'PX'
        },
        {
            name: 'sz',
            label: '丧葬假',
            langtag: 'entities.attensummary.main_grid.columns.sz',
            show: true,
            util: 'PX'
        },
        {
            name: 'js',
            label: '计划生育手术假',
            langtag: 'entities.attensummary.main_grid.columns.js',
            show: true,
            util: 'PX'
        },
        {
            name: 'qtdxj',
            label: '其他带薪假',
            langtag: 'entities.attensummary.main_grid.columns.qtdxj',
            show: true,
            util: 'PX'
        },
        {
            name: 'wqdts',
            label: '未签到天数',
            langtag: 'entities.attensummary.main_grid.columns.wqdts',
            show: true,
            util: 'PX'
        },
        {
            name: 'zhts',
            label: '本月在沪出勤天数',
            langtag: 'entities.attensummary.main_grid.columns.zhts',
            show: true,
            util: 'PX'
        },
        {
            name: 'sjcqts',
            label: '本月实际出勤天数',
            langtag: 'entities.attensummary.main_grid.columns.sjcqts',
            show: true,
            util: 'PX'
        },
        {
            name: 'remarkreason',
            label: '部门审核并注明未签到（或缺勤）原因',
            langtag: 'entities.attensummary.main_grid.columns.remarkreason',
            show: true,
            util: 'PX'
        },
        {
            name: 'bz',
            label: '备注',
            langtag: 'entities.attensummary.main_grid.columns.bz',
            show: true,
            util: 'PX'
        },
        {
            name: 'description',
            label: '说明',
            langtag: 'entities.attensummary.main_grid.columns.description',
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
        srfkey: [
             { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '考勤汇总标识 值不能为空', trigger: 'change' },
            { required: false, validator: (rule:any, value:any, callback:any) => { return (rule.required && (value === null || value === undefined || value === "")) ? false : true;}, message: '考勤汇总标识 值不能为空', trigger: 'blur' },
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
            this.$Notice.error({ title: '错误', desc: 'AttEnsummaryGridView视图表格fetchAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'AttEnsummaryGridView视图表格removeAction参数未配置' });
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
            let srfmajortext = record.attensummaryname;
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
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ attensummary: _keys }),Object.assign({ attensummary: _keys },{viewparams:this.viewparams}), this.showBusyIndicator);
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
            this.$Notice.error({ title: '错误', desc: 'AttEnsummaryGridView视图表格fetchAction参数未配置' });
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
                  filename: "考勤汇总表", //非必填
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
            name: 'nd',
            srfkey: 'EhrCodeList0115',
            codelistType : 'STATIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'yf',
            srfkey: 'CodeList82',
            codelistType : 'STATIC',
            textSeparator: '、',
            renderMode: 'string',
            valueSeparator: ";",
          },
          {
            name: 'zw',
            srfkey: 'EhrCodeList0233',
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
            return Object.is(item.attensummary,$event.attensummary);
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
		const _data: any = localStorage.getItem('attensummary_main_grid');
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
        localStorage.setItem('attensummary_main_grid', JSON.stringify(this.allColumns));
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
                        this.$Notice.error({ title: '错误', desc: 'AttEnsummaryGridView视图表格createAction参数未配置' });
                    }else{
                      Object.assign(item,{viewparams:this.viewparams});
                      let response = await this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                      successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }else if(Object.is(item.rowDataState, 'update')){
                    if(!this.updateAction){
                        this.$Notice.error({ title: '错误', desc: 'AttEnsummaryGridView视图表格updateAction参数未配置' });
                    }else{
                        Object.assign(item,{viewparams:this.viewparams});
                        if(item.attensummary){
                            Object.assign(this.context,{attensummary:item.attensummary});
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
     * 获取对应行class
     *
     * @param {*} $args row 行数据，rowIndex 行索引
     * @returns {void}
     * @memberof Main
     */
    public getRowClassName(args:{row: any,rowIndex: number}){
        let isSelected = this.selections.some((item:any)=>{
            return Object.is(item.attensummary,args.row.attensummary);
        });
        return isSelected ? "grid-selected-row" : "";
    }
}
</script>

<style lang='less'>
@import './main-grid.less';
</style>