<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='attendancemreportmx_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.attendancemreportmx.main_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pimpersonname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pimpersonname' :itemRules="this.rules.pimpersonname" class='' :caption="$t('entities.attendancemreportmx.main_form.details.pimpersonname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pimpersonname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pimpersonname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ygbh.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ygbh' :itemRules="this.rules.ygbh" class='' :caption="$t('entities.attendancemreportmx.main_form.details.ygbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ygbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ygbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ygbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormrogname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ormrogname' :itemRules="this.rules.ormrogname" class='' :caption="$t('entities.attendancemreportmx.main_form.details.ormrogname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormrogname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ormrogname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ormrogname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormrogsectorname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ormrogsectorname' :itemRules="this.rules.ormrogsectorname" class='' :caption="$t('entities.attendancemreportmx.main_form.details.ormrogsectorname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormrogsectorname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ormrogsectorname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ormrogsectorname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gw.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='gw' :itemRules="this.rules.gw" class='' :caption="$t('entities.attendancemreportmx.main_form.details.gw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gw.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.gw"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.gw.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.nd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='nd' :itemRules="this.rules.nd" class='' :caption="$t('entities.attendancemreportmx.main_form.details.nd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nd.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.nd"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.nd.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.yf.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='yf' :itemRules="this.rules.yf" class='' :caption="$t('entities.attendancemreportmx.main_form.details.yf')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.yf.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.yf"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.yf.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.attendancemreportmx.main_form.details.grouppanel1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.day1.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day1' :itemRules="this.rules.day1" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day1')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day1.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day1" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day1.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day2.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day2' :itemRules="this.rules.day2" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day2')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day2.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day2" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day2.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day3.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day3' :itemRules="this.rules.day3" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day3')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day3.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day3" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day3.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day4.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day4' :itemRules="this.rules.day4" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day4')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day4.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day4" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day4.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day5.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day5' :itemRules="this.rules.day5" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day5')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day5.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day5" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day5.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day6.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day6' :itemRules="this.rules.day6" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day6')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day6.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day6" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day6.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day7.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day7' :itemRules="this.rules.day7" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day7')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day7.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day7" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day7.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day8.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day8' :itemRules="this.rules.day8" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day8')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day8.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day8" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day8.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day9.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day9' :itemRules="this.rules.day9" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day9')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day9.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day9" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day9.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day10.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day10' :itemRules="this.rules.day10" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day10')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day10.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day10" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day10.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day11.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day11' :itemRules="this.rules.day11" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day11')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day11.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day11" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day11.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day12.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day12' :itemRules="this.rules.day12" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day12')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day12.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day12" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day12.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day13.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day13' :itemRules="this.rules.day13" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day13')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day13.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day13" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day13.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day14.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day14' :itemRules="this.rules.day14" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day14')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day14.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day14" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day14.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day15.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day15' :itemRules="this.rules.day15" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day15')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day15.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day15" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day15.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day16.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day16' :itemRules="this.rules.day16" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day16')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day16.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day16" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day16.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day17.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day17' :itemRules="this.rules.day17" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day17')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day17.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day17" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day17.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day18.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day18' :itemRules="this.rules.day18" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day18')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day18.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day18" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day18.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day19.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day19' :itemRules="this.rules.day19" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day19')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day19.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day19" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day19.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day20.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day20' :itemRules="this.rules.day20" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day20')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day20.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day20" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day20.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day21.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day21' :itemRules="this.rules.day21" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day21')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day21.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day21" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day21.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day22.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day22' :itemRules="this.rules.day22" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day22')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day22.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day22" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day22.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day23.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day23' :itemRules="this.rules.day23" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day23')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day23.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day23" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day23.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day24.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day24' :itemRules="this.rules.day24" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day24')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day24.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day24" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day24.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day25.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day25' :itemRules="this.rules.day25" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day25')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day25.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day25" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day25.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day26.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day26' :itemRules="this.rules.day26" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day26')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day26.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day26" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day26.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day27.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day27' :itemRules="this.rules.day27" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day27')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day27.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day27" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day27.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day28.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day28' :itemRules="this.rules.day28" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day28')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day28.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day28" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day28.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day29.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day29' :itemRules="this.rules.day29" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day29')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day29.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day29" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day29.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day30.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day30' :itemRules="this.rules.day30" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day30')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day30.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day30" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day30.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.day31.visible" :style="{}"  :lg="{ span: 4, offset: 0 }">
    <app-form-item name='day31' :itemRules="this.rules.day31" class='' :caption="$t('entities.attendancemreportmx.main_form.details.day31')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.day31.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.day31" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.day31.disabled"  
    tag='EhrCodeList0098' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel2.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.attendancemreportmx.main_form.details.grouppanel2')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.kqhz.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='kqhz' :itemRules="this.rules.kqhz" class='' :caption="$t('entities.attendancemreportmx.main_form.details.kqhz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.kqhz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.kqhz"  :disabled="detailsModel.kqhz.disabled" type='textarea' style="" ></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>


    </row>
</i-form>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import AttEndanceMreportmxService from '@/service/att-endance-mreportmx/att-endance-mreportmx-service';
import MainService from './main-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class MainBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof MainBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof MainBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof MainBase
     */
    public getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof MainBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {MainService}
     * @memberof MainBase
     */
    public service: MainService = new MainService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {AttEndanceMreportmxService}
     * @memberof MainBase
     */
    public appEntityService: AttEndanceMreportmxService = new AttEndanceMreportmxService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof MainBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof MainBase
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
     * 工作流审批意见控件绑定值
     *
     * @memberof MainBase
     */
    public srfwfmemo:string = "";
    
    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof MainBase
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof MainBase
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: false }) public autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof MainBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof MainBase
     */
    @Prop() public viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof MainBase
     */
    public formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof MainBase
     */
    public ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @public
     * @type {Subject<any>}
     * @memberof MainBase
     */
    public dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof MainBase
     */
    public dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @public
     * @type {*}
     * @memberof MainBase
     */
    public oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof MainBase
     */
    public data: any = {
        srfupdatedate: null,
        srforikey: null,
        srfkey: null,
        srfmajortext: null,
        srftempmode: null,
        srfuf: null,
        srfdeid: null,
        srfsourcekey: null,
        pimpersonid: null,
        pimpersonname: null,
        ygbh: null,
        ormrogname: null,
        ormrogsectorname: null,
        gw: null,
        nd: null,
        yf: null,
        attendancemreportid2: null,
        day1: null,
        day2: null,
        day3: null,
        day4: null,
        day5: null,
        day6: null,
        day7: null,
        day8: null,
        day9: null,
        day10: null,
        day11: null,
        day12: null,
        day13: null,
        day14: null,
        day15: null,
        day16: null,
        day17: null,
        day18: null,
        day19: null,
        day20: null,
        day21: null,
        day22: null,
        day23: null,
        day24: null,
        day25: null,
        day26: null,
        day27: null,
        day28: null,
        day29: null,
        day30: null,
        day31: null,
        kqhz: null,
        attendancemreportmxid: null,
        attendancemreportmx:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof MainBase
      */
    public currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof MainBase
      */
    public drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof MainBase
      */
    public drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof MainBase
      */
    public saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof MainBase
     */
    public rules: any = {
        srfupdatedate: [
            { type: 'string', message: '更新时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '更新时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '更新时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '更新时间 值不能为空', trigger: 'blur' },
        ],
        srforikey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfkey: [
            { type: 'string', message: '考勤月报明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '考勤月报明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '考勤月报明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '考勤月报明细标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '考勤月报明细名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '考勤月报明细名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '考勤月报明细名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '考勤月报明细名称 值不能为空', trigger: 'blur' },
        ],
        srftempmode: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfuf: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfdeid: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfsourcekey: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        pimpersonid: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        pimpersonname: [
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '姓名 值不能为空', trigger: 'blur' },
        ],
        ygbh: [
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'blur' },
        ],
        ormrogname: [
            { type: 'string', message: '组织名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织名称 值不能为空', trigger: 'blur' },
        ],
        ormrogsectorname: [
            { type: 'string', message: '部门名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门名称 值不能为空', trigger: 'blur' },
        ],
        gw: [
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'blur' },
        ],
        nd: [
            { type: 'string', message: '年度 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '年度 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '年度 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '年度 值不能为空', trigger: 'blur' },
        ],
        yf: [
            { type: 'string', message: '月份 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '月份 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '月份 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '月份 值不能为空', trigger: 'blur' },
        ],
        attendancemreportid2: [
            { type: 'string', message: '考勤月报标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '考勤月报标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '考勤月报标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '考勤月报标识 值不能为空', trigger: 'blur' },
        ],
        day1: [
            { type: 'string', message: '1 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '1 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '1 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '1 值不能为空', trigger: 'blur' },
        ],
        day2: [
            { type: 'string', message: '2 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '2 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '2 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '2 值不能为空', trigger: 'blur' },
        ],
        day3: [
            { type: 'string', message: '3 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '3 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '3 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '3 值不能为空', trigger: 'blur' },
        ],
        day4: [
            { type: 'string', message: '4 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '4 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '4 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '4 值不能为空', trigger: 'blur' },
        ],
        day5: [
            { type: 'string', message: '5 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '5 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '5 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '5 值不能为空', trigger: 'blur' },
        ],
        day6: [
            { type: 'string', message: '6 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '6 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '6 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '6 值不能为空', trigger: 'blur' },
        ],
        day7: [
            { type: 'string', message: '7 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '7 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '7 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '7 值不能为空', trigger: 'blur' },
        ],
        day8: [
            { type: 'string', message: '8 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '8 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '8 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '8 值不能为空', trigger: 'blur' },
        ],
        day9: [
            { type: 'string', message: '9 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '9 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '9 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '9 值不能为空', trigger: 'blur' },
        ],
        day10: [
            { type: 'string', message: '10 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '10 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '10 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '10 值不能为空', trigger: 'blur' },
        ],
        day11: [
            { type: 'string', message: '11 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '11 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '11 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '11 值不能为空', trigger: 'blur' },
        ],
        day12: [
            { type: 'string', message: '12 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '12 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '12 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '12 值不能为空', trigger: 'blur' },
        ],
        day13: [
            { type: 'string', message: '13 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '13 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '13 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '13 值不能为空', trigger: 'blur' },
        ],
        day14: [
            { type: 'string', message: '14 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '14 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '14 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '14 值不能为空', trigger: 'blur' },
        ],
        day15: [
            { type: 'string', message: '15 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '15 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '15 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '15 值不能为空', trigger: 'blur' },
        ],
        day16: [
            { type: 'string', message: '16 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '16 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '16 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '16 值不能为空', trigger: 'blur' },
        ],
        day17: [
            { type: 'string', message: '17 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '17 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '17 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '17 值不能为空', trigger: 'blur' },
        ],
        day18: [
            { type: 'string', message: '18 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '18 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '18 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '18 值不能为空', trigger: 'blur' },
        ],
        day19: [
            { type: 'string', message: '19 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '19 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '19 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '19 值不能为空', trigger: 'blur' },
        ],
        day20: [
            { type: 'string', message: '20 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '20 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '20 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '20 值不能为空', trigger: 'blur' },
        ],
        day21: [
            { type: 'string', message: '21 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '21 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '21 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '21 值不能为空', trigger: 'blur' },
        ],
        day22: [
            { type: 'string', message: '22 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '22 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '22 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '22 值不能为空', trigger: 'blur' },
        ],
        day23: [
            { type: 'string', message: '23 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '23 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '23 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '23 值不能为空', trigger: 'blur' },
        ],
        day24: [
            { type: 'string', message: '24 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '24 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '24 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '24 值不能为空', trigger: 'blur' },
        ],
        day25: [
            { type: 'string', message: '25 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '25 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '25 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '25 值不能为空', trigger: 'blur' },
        ],
        day26: [
            { type: 'string', message: '26 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '26 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '26 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '26 值不能为空', trigger: 'blur' },
        ],
        day27: [
            { type: 'string', message: '27 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '27 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '27 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '27 值不能为空', trigger: 'blur' },
        ],
        day28: [
            { type: 'string', message: '28 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '28 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '28 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '28 值不能为空', trigger: 'blur' },
        ],
        day29: [
            { type: 'string', message: '29 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '29 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '29 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '29 值不能为空', trigger: 'blur' },
        ],
        day30: [
            { type: 'string', message: '30 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '30 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '30 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '30 值不能为空', trigger: 'blur' },
        ],
        day31: [
            { type: 'string', message: '31 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '31 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '31 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '31 值不能为空', trigger: 'blur' },
        ],
        kqhz: [
            { type: 'string', message: '考勤汇总 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '考勤汇总 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '考勤汇总 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '考勤汇总 值不能为空', trigger: 'blur' },
        ],
        attendancemreportmxid: [
            { type: 'string', message: '考勤月报明细标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '考勤月报明细标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '考勤月报明细标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '考勤月报明细标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        group1: new FormGroupPanelModel({ caption: '考勤月报明细基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.attendancemreportmx.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '每日明细', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.attendancemreportmx.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel2: new FormGroupPanelModel({ caption: '统计', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.attendancemreportmx.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '考勤月报明细标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '考勤月报明细名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonid: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonname: new FormItemModel({ caption: '姓名', detailType: 'FORMITEM', name: 'pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ygbh: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'ygbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ormrogname: new FormItemModel({ caption: '组织名称', detailType: 'FORMITEM', name: 'ormrogname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ormrogsectorname: new FormItemModel({ caption: '部门名称', detailType: 'FORMITEM', name: 'ormrogsectorname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        gw: new FormItemModel({ caption: '岗位', detailType: 'FORMITEM', name: 'gw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        nd: new FormItemModel({ caption: '年度', detailType: 'FORMITEM', name: 'nd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        yf: new FormItemModel({ caption: '月份', detailType: 'FORMITEM', name: 'yf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        attendancemreportid2: new FormItemModel({ caption: '考勤月报标识', detailType: 'FORMITEM', name: 'attendancemreportid2', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day1: new FormItemModel({ caption: '1', detailType: 'FORMITEM', name: 'day1', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day2: new FormItemModel({ caption: '2', detailType: 'FORMITEM', name: 'day2', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day3: new FormItemModel({ caption: '3', detailType: 'FORMITEM', name: 'day3', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day4: new FormItemModel({ caption: '4', detailType: 'FORMITEM', name: 'day4', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day5: new FormItemModel({ caption: '5', detailType: 'FORMITEM', name: 'day5', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day6: new FormItemModel({ caption: '6', detailType: 'FORMITEM', name: 'day6', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day7: new FormItemModel({ caption: '7', detailType: 'FORMITEM', name: 'day7', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day8: new FormItemModel({ caption: '8', detailType: 'FORMITEM', name: 'day8', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day9: new FormItemModel({ caption: '9', detailType: 'FORMITEM', name: 'day9', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day10: new FormItemModel({ caption: '10', detailType: 'FORMITEM', name: 'day10', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day11: new FormItemModel({ caption: '11', detailType: 'FORMITEM', name: 'day11', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day12: new FormItemModel({ caption: '12', detailType: 'FORMITEM', name: 'day12', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day13: new FormItemModel({ caption: '13', detailType: 'FORMITEM', name: 'day13', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day14: new FormItemModel({ caption: '14', detailType: 'FORMITEM', name: 'day14', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day15: new FormItemModel({ caption: '15', detailType: 'FORMITEM', name: 'day15', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day16: new FormItemModel({ caption: '16', detailType: 'FORMITEM', name: 'day16', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day17: new FormItemModel({ caption: '17', detailType: 'FORMITEM', name: 'day17', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day18: new FormItemModel({ caption: '18', detailType: 'FORMITEM', name: 'day18', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day19: new FormItemModel({ caption: '19', detailType: 'FORMITEM', name: 'day19', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day20: new FormItemModel({ caption: '20', detailType: 'FORMITEM', name: 'day20', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day21: new FormItemModel({ caption: '21', detailType: 'FORMITEM', name: 'day21', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day22: new FormItemModel({ caption: '22', detailType: 'FORMITEM', name: 'day22', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day23: new FormItemModel({ caption: '23', detailType: 'FORMITEM', name: 'day23', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day24: new FormItemModel({ caption: '24', detailType: 'FORMITEM', name: 'day24', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day25: new FormItemModel({ caption: '25', detailType: 'FORMITEM', name: 'day25', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day26: new FormItemModel({ caption: '26', detailType: 'FORMITEM', name: 'day26', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day27: new FormItemModel({ caption: '27', detailType: 'FORMITEM', name: 'day27', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day28: new FormItemModel({ caption: '28', detailType: 'FORMITEM', name: 'day28', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day29: new FormItemModel({ caption: '29', detailType: 'FORMITEM', name: 'day29', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day30: new FormItemModel({ caption: '30', detailType: 'FORMITEM', name: 'day30', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        day31: new FormItemModel({ caption: '31', detailType: 'FORMITEM', name: 'day31', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        kqhz: new FormItemModel({ caption: '考勤汇总', detailType: 'FORMITEM', name: 'kqhz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        attendancemreportmxid: new FormItemModel({ caption: '考勤月报明细标识', detailType: 'FORMITEM', name: 'attendancemreportmxid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfupdatedate')
    onSrfupdatedateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfupdatedate', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srforikey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srforikey')
    onSrforikeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srforikey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfkey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfkey')
    onSrfkeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfkey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfmajortext 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfmajortext')
    onSrfmajortextChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfmajortext', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srftempmode 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srftempmode')
    onSrftempmodeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srftempmode', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfuf 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfuf')
    onSrfufChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfuf', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfdeid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfdeid')
    onSrfdeidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfdeid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfsourcekey 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimpersonid')
    onPimpersonidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimpersonname')
    onPimpersonnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ygbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ygbh')
    onYgbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ygbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormrogname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormrogname')
    onOrmrognameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormrogname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormrogsectorname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormrogsectorname')
    onOrmrogsectornameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormrogsectorname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.gw')
    onGwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.nd')
    onNdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 yf 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.yf')
    onYfChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'yf', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 attendancemreportid2 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.attendancemreportid2')
    onAttendancemreportid2Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'attendancemreportid2', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day1 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day1')
    onDay1Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day1', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day2 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day2')
    onDay2Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day2', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day3 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day3')
    onDay3Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day3', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day4 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day4')
    onDay4Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day4', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day5 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day5')
    onDay5Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day5', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day6 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day6')
    onDay6Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day6', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day7 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day7')
    onDay7Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day7', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day8 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day8')
    onDay8Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day8', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day9 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day9')
    onDay9Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day9', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day10 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day10')
    onDay10Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day10', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day11 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day11')
    onDay11Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day11', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day12 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day12')
    onDay12Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day12', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day13 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day13')
    onDay13Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day13', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day14 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day14')
    onDay14Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day14', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day15 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day15')
    onDay15Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day15', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day16 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day16')
    onDay16Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day16', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day17 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day17')
    onDay17Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day17', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day18 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day18')
    onDay18Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day18', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day19 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day19')
    onDay19Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day19', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day20 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day20')
    onDay20Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day20', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day21 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day21')
    onDay21Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day21', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day22 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day22')
    onDay22Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day22', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day23 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day23')
    onDay23Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day23', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day24 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day24')
    onDay24Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day24', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day25 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day25')
    onDay25Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day25', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day26 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day26')
    onDay26Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day26', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day27 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day27')
    onDay27Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day27', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day28 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day28')
    onDay28Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day28', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day29 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day29')
    onDay29Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day29', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day30 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day30')
    onDay30Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day30', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 day31 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.day31')
    onDay31Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'day31', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 kqhz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.kqhz')
    onKqhzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'kqhz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 attendancemreportmxid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.attendancemreportmxid')
    onAttendancemreportmxidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'attendancemreportmxid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof MainBase
     */
    public resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
     * @memberof MainBase
      */
    public ResetData(_datas:any){
        if(Object.keys(_datas).length >0){
            Object.keys(_datas).forEach((name: string) => {
                if (this.data.hasOwnProperty(name)) {
                    this.data[name] = null;
                }
            });
        }
    }

    /**
     * 表单逻辑
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof MainBase
     */
    public formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                


















































        if (Object.is(name, '') || Object.is(name, 'yf')) {
            let ret = false;
            const _yf = this.data.yf;
            if (this.$verify.testCond(_yf, 'NOTEQ', '02')) {
                ret = true;
            }
            this.detailsModel.day30.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'yf')) {
            let ret = false;
            const _yf = this.data.yf;
            if (this.$verify.testCond(_yf, 'NOTEQ', '02') && this.$verify.testCond(_yf, 'NOTEQ', '04') && this.$verify.testCond(_yf, 'NOTEQ', '06') && this.$verify.testCond(_yf, 'NOTEQ', '09') && this.$verify.testCond(_yf, 'NOTEQ', '11')) {
                ret = true;
            }
            this.detailsModel.day31.setVisible(ret);
        }



    }

    /**
     * 表单值变化
     *
     * @public
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof MainBase
     */
    public formDataChange({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
        if (this.ignorefieldvaluechange) {
            return;
        }
        this.resetFormData({ name: name, newVal: newVal, oldVal: oldVal });
        this.formLogic({ name: name, newVal: newVal, oldVal: oldVal });
        this.dataChang.next(JSON.stringify(this.data));
    }

    /**
     * 表单加载完成
     *
     * @public
     * @param {*} [data={}]
     * @param {string} [action]
     * @memberof MainBase
     */
    public onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave") || Object.is(action,"submit"))
        // 更新context的实体主键
        if(data.attendancemreportmx){
            Object.assign(this.context,{attendancemreportmx:data.attendancemreportmx})
        }
        this.setFormEnableCond(data);
        this.fillForm(data,action);
        this.oldData = {};
        Object.assign(this.oldData, JSON.parse(JSON.stringify(this.data)));
        this.$store.commit('viewaction/setViewDataChange', { viewtag: this.viewtag, viewdatachange: false });
        this.formLogic({ name: '', newVal: null, oldVal: null });
    }

    /**
     * 值填充
     *
     * @param {*} [_datas={}]
     * @param {string} [action]
     * @memberof MainBase
     */
    public fillForm(_datas: any = {},action:string): void {
        this.ignorefieldvaluechange = true;
        Object.keys(_datas).forEach((name: string) => {
            if (this.data.hasOwnProperty(name)) {
                this.data[name] = _datas[name];
            }
        });
        if(Object.is(action,'loadDraft')){
            this.createDefault();
        }
        if(Object.is(action,'load')){
            this.updateDefault();
        }
        this.$nextTick(function () {
            this.ignorefieldvaluechange = false;
        })
    }

    /**
     * 设置表单项是否启用
     *
     * @public
     * @param {*} data
     * @memberof MainBase
     */
    public setFormEnableCond(data: any): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: FormItemModel = detail;
            formItem.setEnableCond(data.srfuf);
        });
    }

    /**
     * 重置草稿表单状态
     *
     * @public
     * @memberof MainBase
     */
    public resetDraftFormStates(): void {
        const form: any = this.$refs.form;
        if (form) {
            form.resetFields();
        }
    }

    /**
     * 重置校验结果
     *
     * @memberof MainBase
     */
    public resetValidates(): void {
        Object.values(this.detailsModel).forEach((detail: any) => {
            if (!Object.is(detail.detailType, 'FORMITEM')) {
                return;
            }
            const formItem: FormItemModel = detail;
            formItem.setError('');
        });
    }

    /**
     * 填充校验结果 （后台）
     *
     * @param {any[]} fieldErrors
     * @memberof MainBase
     */
    public fillValidates(fieldErrors: any[]): void {
        fieldErrors.forEach((error: any) => {
            const formItem: FormItemModel = this.detailsModel[error.field];
            if (!formItem) {
                return;
            }
            this.$nextTick(() => {
                formItem.setError(error.message);
            });
        });
    }

    /**
     * 表单校验状态
     *
     * @returns {boolean} 
     * @memberof MainBase
     */
    public formValidateStatus(): boolean {
        const form: any = this.$refs.form;
        let validatestate: boolean = true;
        form.validate((valid: boolean) => {
            validatestate = valid ? true : false;
        });
        return validatestate
    }

    /**
     * 获取全部值
     *
     * @returns {*}
     * @memberof MainBase
     */
    public getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof MainBase
     */
    public onFormItemValueChange($event: { name: string, value: any }): void {
        if (!$event) {
            return;
        }
        if (!$event.name || Object.is($event.name, '') || !this.data.hasOwnProperty($event.name)) {
            return;
        }
        this.data[$event.name] = $event.value;
    }

    /**
     * 设置数据项值
     *
     * @param {string} name
     * @param {*} value
     * @returns {void}
     * @memberof MainBase
     */
    public setDataItemValue(name: string, value: any): void {
        if (!name || Object.is(name, '') || !this.data.hasOwnProperty(name)) {
            return;
        }
        if (Object.is(this.data[name], value)) {
            return;
        }
        this.data[name] = value;
    }



    /**
     * 分组界面行为事件
     *
     * @param {*} $event
     * @memberof MainBase
     */
    public groupUIActionClick($event: any): void {
        if (!$event) {
            return;
        }
        const item:any = $event.item;
    }

    /**
     * Vue声明周期(处理组件的输入属性)
     *
     * @memberof MainBase
     */
    public created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof MainBase
     */    
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(tag, this.name)) {
                    return;
                }
                if (Object.is('autoload', action)) {
                    this.autoLoad(data);
                }
                if (Object.is('load', action)) {
                    this.load(data);
                }
                if (Object.is('loaddraft', action)) {
                    if(this.context.srfsourcekey){
                        this.copy(this.context.srfsourcekey);
                    }else{
                        this.loadDraft(data);
                    }
                }
                if (Object.is('save', action)) {
                    this.save(data,data.showResultInfo);
                }
                if (Object.is('remove', action)) {
                    this.remove(data);
                }
                if (Object.is('saveandexit', action)) {
                    this.saveAndExit(data);
                }
                if (Object.is('saveandnew', action)) {
                    this.saveAndNew(data);
                }
                if (Object.is('removeandexit', action)) {
                    this.removeAndExit(data);
                }
                if (Object.is('refresh', action)) {
                    this.refresh(data);
                }
            });
        }
        this.dataChang
            .pipe(
                debounceTime(300),
                distinctUntilChanged()
            ).subscribe((data: any) => {
                if (this.autosave) {
                    this.autoSave();
                }
                const state = !Object.is(JSON.stringify(this.oldData), JSON.stringify(this.data)) ? true : false;
                this.$store.commit('viewaction/setViewDataChange', { viewtag: this.viewtag, viewdatachange: state });
            });
    }

    /**
     * vue 生命周期
     *
     * @memberof MainBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof MainBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
        if (this.dataChangEvent) {
            this.dataChangEvent.unsubscribe();
        }
    }

    /**
     * 拷贝内容
     *
     * @param {*} [arg={}]
     * @memberof @memberof MainBase
     */
    public copy(srfkey: string): void {
        let copyData = this.$store.getters.getCopyData(srfkey);
        copyData.srfkey = Util.createUUID();
        copyData.attendancemreportmx = copyData.srfkey;
        copyData.attendancemreportmxid = copyData.srfkey;
        Object.assign(this.context,{attendancemreportmx:copyData.attendancemreportmx})
        this.data = copyData;
        this.$nextTick(() => {
          this.formState.next({ type: 'load', data: copyData });
          this.data.srfuf = '0';
          this.setFormEnableCond(this.data);
        });
    }

    /**
     *打印
     *@memberof @memberof MainBase
     */
    public print(){
        let _this:any = this;
        _this.$print({id:'attendancemreportmx_main',popTitle:'主编辑表单'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public refresh(args: any[]): void {
        let arg: any = {};
        Object.assign(arg,args[0]);
        if (this.data.srfkey && !Object.is(this.data.srfkey, '')) {
            Object.assign(arg, { srfkey: this.data.srfkey });
            this.load(arg);
            return;
        }
        if (this.data.srfkeys && !Object.is(this.data.srfkeys, '')) {
            Object.assign(arg, { srfkey: this.data.srfkeys });
            this.load(arg);
            return;
        }
    }

    /**
     * 自动加载
     *
     * @param {*} [arg={}]
     * @returns {void}
     * @memberof MainBase
     */
    public autoLoad(arg: any = {}): void {
        if (arg.srfkey && !Object.is(arg.srfkey, '')) {
            Object.assign(arg, { srfkey: arg.srfkey });
            this.load(arg);
            return;
        }
        if (arg.srfkeys && !Object.is(arg.srfkeys, '')) {
            Object.assign(arg, { srfkey: arg.srfkeys });
            this.load(arg);
            return;
        }
        this.loadDraft(arg);
    }

    /**
     * 加载
     *
     * @public
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'AttEndanceMreportmxEditView视图表单loadAction参数未配置' });
            return;
        }
        const arg: any = { ...opt };
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        const get: Promise<any> = this.service.get(this.loadAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        get.then((response: any) => {
            if (response && response.status === 200) {
                const data = response.data;
                this.onFormLoad(data,'load');
                this.$emit('load', data);
                this.$nextTick(() => {
                    this.formState.next({ type: 'load', data: data });
                });
            }
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 加载草稿
     *
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'AttEndanceMreportmxEditView视图表单loaddraftAction参数未配置' });
            return;
        }
        const arg: any = { ...opt } ;
        let viewparamResult:any = Object.assign(arg,this.viewparams);
        let post: Promise<any> = this.service.loadDraft(this.loaddraftAction,JSON.parse(JSON.stringify(this.context)),{viewparams:viewparamResult}, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            if(data.attendancemreportmx){
                Object.assign(this.context,{attendancemreportmx:data.attendancemreportmx})
            }
            this.resetDraftFormStates();
            this.onFormLoad(data,'loadDraft');
            this.$emit('load', data);
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
            setTimeout(() => {
                const form: any = this.$refs.form;
                if (form) {
                    form.fields.forEach((field: any) => {
                        field.validateMessage = "";
                        field.validateState = "";
                        field.validateStatus = false;
                    });
                }
            });
        }).catch((response: any) => {
            if (response && response.status  && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 自动保存
     *
     * @param {*} [opt={}]
     * @memberof MainBase
     */
    public autoSave(opt: any = {}): void {
        if (!this.formValidateStatus()) {
            return;
        }
        const arg: any = { ...opt };
        const data = this.getValues();
        Object.assign(arg, data);
        const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
        if(!action){
            let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
            this.$Notice.error({ title: '错误', desc: 'AttEndanceMreportmxEditView视图表单'+actionName+'参数未配置' });
            return;
        }
        Object.assign(arg,{viewparams:this.viewparams});
        const post: Promise<any> = this.service.add(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response.status || response.status !== 200) {
                if (response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                }
                return;
            }

            const data = response.data;
            this.onFormLoad(data,'autoSave');
            this.$emit('save', data);
            this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
            this.$nextTick(() => {
                this.formState.next({ type: 'save', data: data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 保存
     *
     * @param {*} [opt={}]
     * @param {boolean} [showResultInfo] 
     * @param {boolean} [ifStateNext] formState是否下发通知
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async save(opt: any = {}, showResultInfo?: boolean, ifStateNext: boolean = true): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            showResultInfo = showResultInfo === undefined ? true : false;
            if (!this.formValidateStatus()) {
                this.$Notice.error({ title: '错误', desc: '值规则校验异常' });
                return;
            }
            const arg: any = { ...opt };
            const data = this.getValues();
            Object.assign(arg, data);
            Object.assign(arg, this.context);
            if (ifStateNext) {
                this.drcounter = 0;
                if(this.drcounter !== 0){
                    this.drsaveopt = opt;
                    this.formState.next({ type: 'beforesave', data: arg });//先通知关系界面保存
                    this.saveState = resolve;
                    return;
                }
            }
            const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
            if(!action){
                let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
                this.$Notice.error({ title: '错误', desc: 'AttEndanceMreportmxEditView视图表单'+actionName+'参数未配置' });
                return;
            }
            Object.assign(arg,{viewparams:this.viewparams});
            const post: Promise<any> = Object.is(data.srfuf, '1')?this.service.update(action, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(action,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
            post.then((response: any) => {
                if (!response.status || response.status !== 200) {
                    if (response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                    }
                    return;
                }

                const data = response.data;
                this.onFormLoad(data,'save');
                this.$emit('save', data);
                this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: data });
                });
                if (showResultInfo) {
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;保存成功！' });
                }
                resolve(response);
            }).catch((response: any) => {
                if (response && response.status  && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
        })
    }

    /**
    * 删除
    *
    * @public
    * @param {*} [opt={}]
    * @memberof MainBase
    */
    public remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'AttEndanceMreportmxEditView视图表单removeAction参数未配置' });
                return;
            }
            const arg: any = opt[0];
            const _this: any = this;
            Object.assign(arg,{viewparams:this.viewparams});
            this.service.delete(_this.removeAction, JSON.parse(JSON.stringify(this.context)),arg, showResultInfo).then((response: any) => {
                if (response) {
                    const data = response.data;
                    this.$emit('remove',data);
                    this.formState.next({ type: 'remove', data: data });
                    this.data.ismodify = false;
                    this.$Notice.success({ title: '', desc: (data.srfmajortext ? data.srfmajortext : '') + '&nbsp;删除成功！' });
                    resolve(response);
                }
            }).catch((error: any) => {
                const { data: _data } = error;
                this.$Notice.error({ title: _data.title, desc: _data.message });
                reject(error);
            });
        });
    }

    /**
     * 工作流启动
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async wfstart(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            const _this: any = this;
            const post: Promise<any> = _this.save({},false);
            post.then((response:any) =>{
                const arg:any = response.data;
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
                }
                const result: Promise<any> = this.service.wfstart(_this.WFStartAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: '工作流启动失败, ' + response.data.message });
                        }
                        return;
                    }
                    this.$Notice.info({ title: '', desc: '工作流启动成功' });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
                        reject(response);
                        return;
                    }
                    reject(response);
            })
        });
    }

    /**
     * 工作流提交
     *
     * @param {*} [data={}]
     * @param {*} [localdata={}]
     * @returns {Promise<any>}
     * @memberof MainBase
     */
    public async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.attendancemreportmx || Object.is(arg.attendancemreportmx, '')) {
            return;
        }
        const post: Promise<any> = Object.is(arg.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response:any) =>{
                const arg:any = response.data;
                // 保存完成UI处理
                this.onFormLoad(arg,'save');
                this.$emit('save', arg);
                this.$nextTick(() => {
                    this.formState.next({ type: 'save', data: arg });
                });
                // 准备提交参数
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
                }
                // 强制补充srfwfmemo
                if(this.srfwfmemo){
                    Object.assign(arg,{srfwfmemo:this.srfwfmemo});
                }
                const result: Promise<any> = this.service.wfsubmit(_this.WFSubmitAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: '工作流提交失败, ' + response.data.message });
                        }
                        return;
                    }
                    this.onFormLoad(arg,'submit');
                    this.$store.dispatch('viewaction/datasaved', { viewtag: this.viewtag });
                    this.$Notice.info({ title: '', desc: '工作流提交成功' });
                    resolve(response);
            }).catch((response: any) => {
                if (response && response.status && response.data) {
                    this.$Notice.error({ title: '错误', desc: response.data.message });
                    reject(response);
                    return;
                }
                if (!response || !response.status || !response.data) {
                    this.$Notice.error({ title: '错误', desc: '系统异常' });
                    reject(response);
                    return;
                }
                reject(response);
            });
            }).catch((response: any) => {
                    if (response && response.status && response.data) {
                        this.$Notice.error({ title: '错误', desc: response.data.message });
                        reject(response);
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
                        reject(response);
                        return;
                    }
                    reject(response);
            })
        })
    }

    /**
     * 表单项更新
     *
     * @param {string} mode 界面行为名称
     * @param {*} [data={}] 请求数据
     * @param {string[]} updateDetails 更新项
     * @param {boolean} [showloading] 是否显示加载状态
     * @returns {void}
     * @memberof MainBase
     */
    public updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
        if (!mode || (mode && Object.is(mode, ''))) {
            return;
        }
        const arg: any = { ...data };
        Object.assign(arg,this.viewparams);
        const post: Promise<any> = this.service.frontLogic(mode,JSON.parse(JSON.stringify(this.context)),arg, showloading);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: '错误', desc: '表单项更新失败' });
                return;
            }
            const data = response.data;
            const _data: any = {};
            updateDetails.forEach((name: string) => {
                if (!data.hasOwnProperty(name)) {
                    return;
                }
                Object.assign(_data, { [name]: data[name] });
            });
            this.setFormEnableCond(_data);
            this.fillForm(_data,'updateFormItem');
            this.formLogic({ name: '', newVal: null, oldVal: null });
            this.dataChang.next(JSON.stringify(this.data));
            this.$nextTick(() => {
                this.formState.next({ type: 'updateformitem', ufimode: arg.srfufimode, data: _data });
            });
        }).catch((response: any) => {
            if (response && response.status && response.data) {
                this.$Notice.error({ title: '错误', desc: response.data.message });
                return;
            }
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常' });
                return;
            }
        });
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof MainBase
     */
    public onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public saveAndExit(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.currentAction = "saveAndExit";
            _this.save([arg]).then((res) =>{
                if(res){
                    _this.closeView(res.data);
                }
                resolve(res);
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
     * 保存并新建
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public saveAndNew(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.currentAction = "saveAndNew";
            _this.save([arg]).then((res) =>{
                _this.ResetData(res);
                _this.loadDraft({});
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
     * 删除并退出
     *
     * @param {any[]} args
     * @memberof MainBase
     */
    public removeAndExit(data:any[]):Promise<any>{
        let _this = this;
        return new Promise((resolve: any, reject: any) =>{
            let arg: any = {};
            if(data && data.length > 0){
                Object.assign(arg,data[0]);
            }
            _this.remove([arg]).then((res) =>{
                if(res){
                  _this.closeView(res.data);
                }
                resolve(res);
            }).catch((error) =>{
                reject(error);
            })
        })
    }

    /**
    * 关系界面数据保存完成
    *
    * @param {any} $event
    * @memberof MainBase
    */
    public drdatasaved($event:any){
        let _this = this;
        this.drcounter--;
        if(this.drcounter === 0){
            this.save(this.drsaveopt, undefined, false).then((res) =>{
                this.saveState(res);
                this.drsaveopt = {};
                if(Object.is(_this.currentAction, "saveAndNew")){
                    _this.ResetData(res);
                    _this.loadDraft({});
                }else if(Object.is(_this.currentAction, "saveAndExit")){
                    if(res){
                        _this.closeView(res.data);
                    }
                }
            });
        }
    }

    /**
     * 新建默认值
     * @memberof MainBase
     */
    public createDefault(){                    
    }

    /**
     * 更新默认值
     * @memberof MainBase
     */
    public updateDefault(){                    
    }

    
}
</script>

<style lang='less'>
@import './main-form.less';
</style>