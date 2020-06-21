<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='pcmdetail_main' style="">
    <input style="display:none;" />
    <row >
            
<i-col v-show="detailsModel.group1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.group1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmdetail.main_form.details.group1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.ygbh.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ygbh' :itemRules="this.rules.ygbh" class='' :caption="$t('entities.pcmdetail.main_form.details.ygbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ygbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ygbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ygbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimpersonname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pimpersonname' :itemRules="this.rules.pimpersonname" class='' :caption="$t('entities.pcmdetail.main_form.details.pimpersonname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pimpersonname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pimpersonname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zjhm.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zjhm' :itemRules="this.rules.zjhm" class='' :caption="$t('entities.pcmdetail.main_form.details.zjhm')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zjhm.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zjhm"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zjhm.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.csrq.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='csrq' :itemRules="this.rules.csrq" class='' :caption="$t('entities.pcmdetail.main_form.details.csrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.csrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.csrq" :disabled="detailsModel.csrq.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.csrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jg.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='jg' :itemRules="this.rules.jg" class='' :caption="$t('entities.pcmdetail.main_form.details.jg')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jg.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.jg" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.jg.disabled"  
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.nj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='nj' :itemRules="this.rules.nj" class='' :caption="$t('entities.pcmdetail.main_form.details.nj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nj.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.nj"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.nj.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xb.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xb' :itemRules="this.rules.xb" class='' :caption="$t('entities.pcmdetail.main_form.details.xb')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xb.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.xb" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.xb.disabled"  
    tag='EhrCodeList0072' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.lxdh.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='lxdh' :itemRules="this.rules.lxdh" class='' :caption="$t('entities.pcmdetail.main_form.details.lxdh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lxdh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.lxdh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.lxdh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hyzk.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='hyzk' :itemRules="this.rules.hyzk" class='' :caption="$t('entities.pcmdetail.main_form.details.hyzk')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hyzk.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.hyzk" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.hyzk.disabled"  
    tag='EhrCodeList0075' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.mz.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='mz' :itemRules="this.rules.mz" class='' :caption="$t('entities.pcmdetail.main_form.details.mz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.mz.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.mz" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.mz.disabled"  
    tag='EhrCodeList0066' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hkxz.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='hkxz' :itemRules="this.rules.hkxz" class='' :caption="$t('entities.pcmdetail.main_form.details.hkxz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hkxz.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.hkxz" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.hkxz.disabled"  
    tag='EhrCodeList0070' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bz.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bz' :itemRules="this.rules.bz" class='' :caption="$t('entities.pcmdetail.main_form.details.bz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bz"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bz.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hjdz.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='hjdz' :itemRules="this.rules.hjdz" class='' :caption="$t('entities.pcmdetail.main_form.details.hjdz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hjdz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.hjdz"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.hjdz.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimmajorsetypename.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pimmajorsetypename' :itemRules="this.rules.pimmajorsetypename" class='' :caption="$t('entities.pcmdetail.main_form.details.pimmajorsetypename')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimmajorsetypename.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pimmajorsetypename"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pimmajorsetypename.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rzqd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='rzqd' :itemRules="this.rules.rzqd" class='' :caption="$t('entities.pcmdetail.main_form.details.rzqd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rzqd.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.rzqd" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.rzqd.disabled"  
    tag='EhrCodeList0041' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.yglx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='yglx' :itemRules="this.rules.yglx" class='' :caption="$t('entities.pcmdetail.main_form.details.yglx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.yglx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.yglx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.yglx.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.grouppanel2.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmdetail.main_form.details.grouppanel2')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.dyxlbyyx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='dyxlbyyx' :itemRules="this.rules.dyxlbyyx" class='' :caption="$t('entities.pcmdetail.main_form.details.dyxlbyyx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dyxlbyyx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.dyxlbyyx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.dyxlbyyx.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.dyxljssj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='dyxljssj' :itemRules="this.rules.dyxljssj" class='' :caption="$t('entities.pcmdetail.main_form.details.dyxljssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dyxljssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.dyxljssj" :disabled="detailsModel.dyxljssj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.dyxljssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zgxljssj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zgxljssj' :itemRules="this.rules.zgxljssj" class='' :caption="$t('entities.pcmdetail.main_form.details.zgxljssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zgxljssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.zgxljssj" :disabled="detailsModel.zgxljssj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.zgxljssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.dyxlsxzy.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='dyxlsxzy' :itemRules="this.rules.dyxlsxzy" class='' :caption="$t('entities.pcmdetail.main_form.details.dyxlsxzy')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dyxlsxzy.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.dyxlsxzy"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.dyxlsxzy.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.firsteducation.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='firsteducation' :itemRules="this.rules.firsteducation" class='' :caption="$t('entities.pcmdetail.main_form.details.firsteducation')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.firsteducation.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.firsteducation" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.firsteducation.disabled" 
  style="width:100px;width: 100px;" 
  tag='EhrCodeList0401' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfzgxl.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfzgxl' :itemRules="this.rules.sfzgxl" class='' :caption="$t('entities.pcmdetail.main_form.details.sfzgxl')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sfzgxl.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.sfzgxl" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.sfzgxl.disabled" 
  style="width:100px;width: 100px;" 
  tag='EhrCodeList0401' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zgxlsxzy.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zgxlsxzy' :itemRules="this.rules.zgxlsxzy" class='' :caption="$t('entities.pcmdetail.main_form.details.zgxlsxzy')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zgxlsxzy.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zgxlsxzy"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zgxlsxzy.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zgxlbyyx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zgxlbyyx' :itemRules="this.rules.zgxlbyyx" class='' :caption="$t('entities.pcmdetail.main_form.details.zgxlbyyx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zgxlbyyx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zgxlbyyx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zgxlbyyx.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xllx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xllx' :itemRules="this.rules.xllx" class='' :caption="$t('entities.pcmdetail.main_form.details.xllx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xllx.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.xllx" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.xllx.disabled"  
    tag='EhrCodeList0131' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xxlb.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='xxlb' :itemRules="this.rules.xxlb" class='' :caption="$t('entities.pcmdetail.main_form.details.xxlb')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xxlb.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.xxlb" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.xxlb.disabled"  
    tag='EhrCodeList0208' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sbcjd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sbcjd' :itemRules="this.rules.sbcjd" class='' :caption="$t('entities.pcmdetail.main_form.details.sbcjd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sbcjd.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.sbcjd"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.sbcjd.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zzmm.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zzmm' :itemRules="this.rules.zzmm" class='' :caption="$t('entities.pcmdetail.main_form.details.zzmm')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zzmm.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.zzmm" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.zzmm.disabled"  
    tag='EhrCodeList0029' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.px.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='px' :itemRules="this.rules.px" class='' :caption="$t('entities.pcmdetail.main_form.details.px')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.px.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.px"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.px.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel1.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmdetail.main_form.details.grouppanel1')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.bdwgznx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bdwgznx' :itemRules="this.rules.bdwgznx" class='' :caption="$t('entities.pcmdetail.main_form.details.bdwgznx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bdwgznx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bdwgznx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bdwgznx.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.bjgznx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='bjgznx' :itemRules="this.rules.bjgznx" class='' :caption="$t('entities.pcmdetail.main_form.details.bjgznx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.bjgznx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.bjgznx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.bjgznx.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.careername.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='careername' :itemRules="this.rules.careername" class='' :caption="$t('entities.pcmdetail.main_form.details.careername')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.careername.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.careername"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.careername.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zjxtgznx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zjxtgznx' :itemRules="this.rules.zjxtgznx" class='' :caption="$t('entities.pcmdetail.main_form.details.zjxtgznx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zjxtgznx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zjxtgznx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zjxtgznx.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.cjgzsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='cjgzsj' :itemRules="this.rules.cjgzsj" class='' :caption="$t('entities.pcmdetail.main_form.details.cjgzsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.cjgzsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.cjgzsj" :disabled="detailsModel.cjgzsj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.cjgzsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.tozjdate.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='tozjdate' :itemRules="this.rules.tozjdate" class='' :caption="$t('entities.pcmdetail.main_form.details.tozjdate')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.tozjdate.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.tozjdate" :disabled="detailsModel.tozjdate.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.tozjdate = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.dbdwsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='dbdwsj' :itemRules="this.rules.dbdwsj" class='' :caption="$t('entities.pcmdetail.main_form.details.dbdwsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dbdwsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.dbdwsj" :disabled="detailsModel.dbdwsj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.dbdwsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rank.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='rank' :itemRules="this.rules.rank" class='' :caption="$t('entities.pcmdetail.main_form.details.rank')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rank.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.rank" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.rank.disabled"  
    tag='EhrCodeList0025' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rdsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='rdsj' :itemRules="this.rules.rdsj" class='' :caption="$t('entities.pcmdetail.main_form.details.rdsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rdsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.rdsj" :disabled="detailsModel.rdsj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.rdsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.dzjbjsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='dzjbjsj' :itemRules="this.rules.dzjbjsj" class='' :caption="$t('entities.pcmdetail.main_form.details.dzjbjsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dzjbjsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.dzjbjsj" :disabled="detailsModel.dzjbjsj.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.dzjbjsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gw.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='gw' :itemRules="this.rules.gw" class='' :caption="$t('entities.pcmdetail.main_form.details.gw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gw.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.gw"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.gw.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gznx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='gznx' :itemRules="this.rules.gznx" class='' :caption="$t('entities.pcmdetail.main_form.details.gznx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gznx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.gznx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.gznx.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gwtype.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='gwtype' :itemRules="this.rules.gwtype" class='' :caption="$t('entities.pcmdetail.main_form.details.gwtype')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gwtype.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.gwtype" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.gwtype.disabled"  
    tag='EhrCodeList0140' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jxkhcj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='jxkhcj' :itemRules="this.rules.jxkhcj" class='' :caption="$t('entities.pcmdetail.main_form.details.jxkhcj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jxkhcj.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.jxkhcj"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.jxkhcj.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zw.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zw' :itemRules="this.rules.zw" class='' :caption="$t('entities.pcmdetail.main_form.details.zw')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zw.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.zw" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.zw.disabled"  
    tag='EhrCodeList0233' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zcbh.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zcbh' :itemRules="this.rules.zcbh" class='' :caption="$t('entities.pcmdetail.main_form.details.zcbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zcbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zcbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zcbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfzckjs.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='sfzckjs' :itemRules="this.rules.sfzckjs" class='' :caption="$t('entities.pcmdetail.main_form.details.sfzckjs')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sfzckjs.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
  v-model="data.sfzckjs" 
  :data="data" 
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.sfzckjs.disabled" 
  style="width:100px;width: 100px;" 
  tag='EhrCodeList0401' 
  codelistType='STATIC'
  placeholder='请选择...'>
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgsectorname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ormorgsectorname' :itemRules="this.rules.ormorgsectorname" class='' :caption="$t('entities.pcmdetail.main_form.details.ormorgsectorname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgsectorname.error" :isEmptyCaption="false" labelPos="LEFT">
    
<app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :localContext ='{ }' 
  :localParam ='{ }' 
  :disabled="detailsModel.ormorgsectorname.disabled"
  name='ormorgsectorname'
  deMajorField='orgsectorname'
  deKeyField='ormorgsector'
  :service="service"
  :acParams="{ serviceName: 'OrmOrgsectorService', interfaceName: 'FetchDefault'}"
  valueitem='ormorgsectorid' 
  :value="data.ormorgsectorname" 
  editortype="" 
  :pickupView="{ viewname: 'orm-orgsector-pickup-view', title: $t('entities.ormorgsector.views.pickupview.title'), deResParameters: [{ pathName: 'ormorgs', parameterName: 'ormorg' }, ], parameters: [{ pathName: 'ormorgsectors', parameterName: 'ormorgsector' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimvocationalcatalogname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='pimvocationalcatalogname' :itemRules="this.rules.pimvocationalcatalogname" class='' :caption="$t('entities.pcmdetail.main_form.details.pimvocationalcatalogname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimvocationalcatalogname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pimvocationalcatalogname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pimvocationalcatalogname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ormorgname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='ormorgname' :itemRules="this.rules.ormorgname" class='' :caption="$t('entities.pcmdetail.main_form.details.ormorgname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ormorgname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ormorgname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ormorgname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel3.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel3.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmdetail.main_form.details.grouppanel3')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.zgzsbh.visible" :style="{}"  :lg="{ span: 5, offset: 0 }">
    <app-form-item name='zgzsbh' :itemRules="this.rules.zgzsbh" class='' :caption="$t('entities.pcmdetail.main_form.details.zgzsbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zgzsbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zgzsbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zgzsbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimqualtypename.visible" :style="{}"  :lg="{ span: 5, offset: 0 }">
    <app-form-item name='pimqualtypename' :itemRules="this.rules.pimqualtypename" class='' :caption="$t('entities.pcmdetail.main_form.details.pimqualtypename')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimqualtypename.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pimqualtypename"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pimqualtypename.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.kstgkms.visible" :style="{}"  :lg="{ span: 5, offset: 0 }">
    <app-form-item name='kstgkms' :itemRules="this.rules.kstgkms" class='' :caption="$t('entities.pcmdetail.main_form.details.kstgkms')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.kstgkms.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.kstgkms"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.kstgkms.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel4.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' :uiActionGroup="detailsModel.grouppanel4.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pcmdetail.main_form.details.grouppanel4')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.qsrq.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='qsrq' :itemRules="this.rules.qsrq" class='' :caption="$t('entities.pcmdetail.main_form.details.qsrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.qsrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.qsrq" :disabled="detailsModel.qsrq.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.qsrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jsrq.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='jsrq' :itemRules="this.rules.jsrq" class='' :caption="$t('entities.pcmdetail.main_form.details.jsrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jsrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.jsrq" :disabled="detailsModel.jsrq.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.jsrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.htqx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='htqx' :itemRules="this.rules.htqx" class='' :caption="$t('entities.pcmdetail.main_form.details.htqx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.htqx.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.htqx" :disabled="detailsModel.htqx.disabled" style="min-width: 150px; width:100px;" @on-change="(val1, val2) => { this.data.htqx = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.contracttype.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='contracttype' :itemRules="this.rules.contracttype" class='' :caption="$t('entities.pcmdetail.main_form.details.contracttype')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.contracttype.error" :isEmptyCaption="false" labelPos="LEFT">
    
 <dropdown-list 
    v-model="data.contracttype" 
    :data="data" 
    :context="context"
    :viewparams="viewparams"
    :localContext ='{ }' 
    :localParam ='{ }' 
    :disabled="detailsModel.contracttype.disabled"  
    tag='EhrCodeList0107' 
    codelistType='DYNAMIC'
    placeholder='请选择...' style="">
 </dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.htsyq.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='htsyq' :itemRules="this.rules.htsyq" class='' :caption="$t('entities.pcmdetail.main_form.details.htsyq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.htsyq.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.htsyq"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.htsyq.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

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
import PcmDetailService from '@/service/pcm-detail/pcm-detail-service';
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
     * @type {PcmDetailService}
     * @memberof MainBase
     */
    public appEntityService: PcmDetailService = new PcmDetailService({ $store: this.$store });
    


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
        ygbh: null,
        pimpersonname: null,
        zjhm: null,
        csrq: null,
        jg: null,
        nj: null,
        xb: null,
        lxdh: null,
        hyzk: null,
        mz: null,
        hkxz: null,
        bz: null,
        hjdz: null,
        pimmajorsetypename: null,
        rzqd: null,
        yglx: null,
        dyxlbyyx: null,
        dyxljssj: null,
        zgxljssj: null,
        dyxlsxzy: null,
        firsteducation: null,
        sfzgxl: null,
        zgxlsxzy: null,
        zgxlbyyx: null,
        xllx: null,
        xxlb: null,
        sbcjd: null,
        zzmm: null,
        px: null,
        bdwgznx: null,
        bjgznx: null,
        careername: null,
        zjxtgznx: null,
        cjgzsj: null,
        tozjdate: null,
        dbdwsj: null,
        rank: null,
        rdsj: null,
        dzjbjsj: null,
        gw: null,
        gznx: null,
        gwtype: null,
        jxkhcj: null,
        zw: null,
        zcbh: null,
        sfzckjs: null,
        ormorgsectorname: null,
        pimvocationalcatalogname: null,
        ormorgname: null,
        zgzsbh: null,
        pimqualtypename: null,
        kstgkms: null,
        qsrq: null,
        jsrq: null,
        htqx: null,
        contracttype: null,
        htsyq: null,
        ormorgsectorid: null,
        pcmdetailid: null,
        pcmdetail:null,
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
            { type: 'string', message: '人员明细表标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员明细表标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员明细表标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员明细表标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '人员明细表名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员明细表名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员明细表名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员明细表名称 值不能为空', trigger: 'blur' },
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
        ygbh: [
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工编号 值不能为空', trigger: 'blur' },
        ],
        pimpersonname: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        zjhm: [
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '证件号码 值不能为空', trigger: 'blur' },
        ],
        csrq: [
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'blur' },
        ],
        jg: [
            { type: 'string', message: '籍贯 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '籍贯 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '籍贯 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '籍贯 值不能为空', trigger: 'blur' },
        ],
        nj: [
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'blur' },
        ],
        xb: [
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'blur' },
        ],
        lxdh: [
            { type: 'string', message: '联系方式 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '联系方式 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '联系方式 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '联系方式 值不能为空', trigger: 'blur' },
        ],
        hyzk: [
            { type: 'string', message: '婚姻状况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '婚姻状况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '婚姻状况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '婚姻状况 值不能为空', trigger: 'blur' },
        ],
        mz: [
            { type: 'string', message: '民族 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '民族 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '民族 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '民族 值不能为空', trigger: 'blur' },
        ],
        hkxz: [
            { type: 'string', message: '户口性质 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '户口性质 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '户口性质 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '户口性质 值不能为空', trigger: 'blur' },
        ],
        bz: [
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '备注 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '备注 值不能为空', trigger: 'blur' },
        ],
        hjdz: [
            { type: 'string', message: '户籍地址 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '户籍地址 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '户籍地址 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '户籍地址 值不能为空', trigger: 'blur' },
        ],
        pimmajorsetypename: [
            { type: 'string', message: '所属业务系统 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '所属业务系统 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '所属业务系统 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '所属业务系统 值不能为空', trigger: 'blur' },
        ],
        rzqd: [
            { type: 'string', message: '入职渠道 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '入职渠道 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '入职渠道 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '入职渠道 值不能为空', trigger: 'blur' },
        ],
        yglx: [
            { type: 'string', message: '员工类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工类型 值不能为空', trigger: 'blur' },
        ],
        dyxlbyyx: [
            { type: 'string', message: '第一学历毕业院校 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '第一学历毕业院校 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '第一学历毕业院校 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '第一学历毕业院校 值不能为空', trigger: 'blur' },
        ],
        dyxljssj: [
            { type: 'string', message: '第一学历毕业时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '第一学历毕业时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '第一学历毕业时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '第一学历毕业时间 值不能为空', trigger: 'blur' },
        ],
        zgxljssj: [
            { type: 'string', message: '最高学历毕业时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '最高学历毕业时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '最高学历毕业时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '最高学历毕业时间 值不能为空', trigger: 'blur' },
        ],
        dyxlsxzy: [
            { type: 'string', message: '第一学历所学专业 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '第一学历所学专业 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '第一学历所学专业 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '第一学历所学专业 值不能为空', trigger: 'blur' },
        ],
        firsteducation: [
            { type: 'number', message: '是否第一学历 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否第一学历 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否第一学历 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否第一学历 值不能为空', trigger: 'blur' },
        ],
        sfzgxl: [
            { type: 'number', message: '是否最高学历 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否最高学历 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否最高学历 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否最高学历 值不能为空', trigger: 'blur' },
        ],
        zgxlsxzy: [
            { type: 'string', message: '最高学历所学专业 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '最高学历所学专业 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '最高学历所学专业 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '最高学历所学专业 值不能为空', trigger: 'blur' },
        ],
        zgxlbyyx: [
            { type: 'string', message: '最高学历毕业院校 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '最高学历毕业院校 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '最高学历毕业院校 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '最高学历毕业院校 值不能为空', trigger: 'blur' },
        ],
        xllx: [
            { type: 'string', message: '第一学历学习形式 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '第一学历学习形式 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '第一学历学习形式 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '第一学历学习形式 值不能为空', trigger: 'blur' },
        ],
        xxlb: [
            { type: 'string', message: '第一学历学校类别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '第一学历学校类别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '第一学历学校类别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '第一学历学校类别 值不能为空', trigger: 'blur' },
        ],
        sbcjd: [
            { type: 'string', message: '社保参缴地 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '社保参缴地 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '社保参缴地 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '社保参缴地 值不能为空', trigger: 'blur' },
        ],
        zzmm: [
            { type: 'string', message: '政治面貌 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '政治面貌 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '政治面貌 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '政治面貌 值不能为空', trigger: 'blur' },
        ],
        px: [
            { type: 'string', message: '培训 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '培训 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '培训 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '培训 值不能为空', trigger: 'blur' },
        ],
        bdwgznx: [
            { type: 'number', message: '本单位工作年限 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '本单位工作年限 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '本单位工作年限 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '本单位工作年限 值不能为空', trigger: 'blur' },
        ],
        bjgznx: [
            { type: 'number', message: '局工作年限 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '局工作年限 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '局工作年限 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '局工作年限 值不能为空', trigger: 'blur' },
        ],
        careername: [
            { type: 'string', message: '专业技术资格（职称） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '专业技术资格（职称） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '专业技术资格（职称） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '专业技术资格（职称） 值不能为空', trigger: 'blur' },
        ],
        zjxtgznx: [
            { type: 'number', message: '建筑系统工作年限 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '建筑系统工作年限 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '建筑系统工作年限 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '建筑系统工作年限 值不能为空', trigger: 'blur' },
        ],
        cjgzsj: [
            { type: 'string', message: '参加工作时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '参加工作时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '参加工作时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '参加工作时间 值不能为空', trigger: 'blur' },
        ],
        tozjdate: [
            { type: 'string', message: '建筑系统工作时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '建筑系统工作时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '建筑系统工作时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '建筑系统工作时间 值不能为空', trigger: 'blur' },
        ],
        dbdwsj: [
            { type: 'string', message: '本单位工作时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '本单位工作时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '本单位工作时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '本单位工作时间 值不能为空', trigger: 'blur' },
        ],
        rank: [
            { type: 'string', message: '职级 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职级 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职级 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职级 值不能为空', trigger: 'blur' },
        ],
        rdsj: [
            { type: 'string', message: '入党时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '入党时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '入党时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '入党时间 值不能为空', trigger: 'blur' },
        ],
        dzjbjsj: [
            { type: 'string', message: '局工作时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '局工作时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '局工作时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '局工作时间 值不能为空', trigger: 'blur' },
        ],
        gw: [
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'blur' },
        ],
        gznx: [
            { type: 'number', message: '工作年限 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '工作年限 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '工作年限 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '工作年限 值不能为空', trigger: 'blur' },
        ],
        gwtype: [
            { type: 'string', message: '岗位类别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位类别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位类别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位类别 值不能为空', trigger: 'blur' },
        ],
        jxkhcj: [
            { type: 'string', message: '绩效考核成绩（近两年） 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '绩效考核成绩（近两年） 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '绩效考核成绩（近两年） 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '绩效考核成绩（近两年） 值不能为空', trigger: 'blur' },
        ],
        zw: [
            { type: 'string', message: '职务 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职务 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职务 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职务 值不能为空', trigger: 'blur' },
        ],
        zcbh: [
            { type: 'string', message: '职称编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职称编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职称编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职称编号 值不能为空', trigger: 'blur' },
        ],
        sfzckjs: [
            { type: 'number', message: '是否注册会计师 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '是否注册会计师 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '是否注册会计师 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '是否注册会计师 值不能为空', trigger: 'blur' },
        ],
        ormorgsectorname: [
            { type: 'string', message: '部门名称 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门名称 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门名称 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门名称 值不能为空', trigger: 'blur' },
        ],
        pimvocationalcatalogname: [
            { type: 'string', message: '执(职)业资格证书 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '执(职)业资格证书 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '执(职)业资格证书 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '执(职)业资格证书 值不能为空', trigger: 'blur' },
        ],
        ormorgname: [
            { type: 'string', message: '工作单位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '工作单位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '工作单位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '工作单位 值不能为空', trigger: 'blur' },
        ],
        zgzsbh: [
            { type: 'string', message: '注册会计师证书编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '注册会计师证书编号 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '注册会计师证书编号 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '注册会计师证书编号 值不能为空', trigger: 'blur' },
        ],
        pimqualtypename: [
            { type: 'string', message: '岗位证书 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位证书 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位证书 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位证书 值不能为空', trigger: 'blur' },
        ],
        kstgkms: [
            { type: 'string', message: '注册会计师专业阶段考试已通过科目数 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '注册会计师专业阶段考试已通过科目数 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '注册会计师专业阶段考试已通过科目数 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '注册会计师专业阶段考试已通过科目数 值不能为空', trigger: 'blur' },
        ],
        qsrq: [
            { type: 'string', message: '签订日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '签订日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '签订日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '签订日期 值不能为空', trigger: 'blur' },
        ],
        jsrq: [
            { type: 'string', message: '结束日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '结束日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '结束日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '结束日期 值不能为空', trigger: 'blur' },
        ],
        htqx: [
            { type: 'string', message: '合同期限 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '合同期限 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '合同期限 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '合同期限 值不能为空', trigger: 'blur' },
        ],
        contracttype: [
            { type: 'string', message: '劳动合同性质 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '劳动合同性质 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '劳动合同性质 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '劳动合同性质 值不能为空', trigger: 'blur' },
        ],
        htsyq: [
            { type: 'string', message: '合同试用期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '合同试用期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '合同试用期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '合同试用期 值不能为空', trigger: 'blur' },
        ],
        ormorgsectorid: [
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'blur' },
        ],
        pcmdetailid: [
            { type: 'string', message: '人员明细表标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员明细表标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员明细表标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员明细表标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof MainBase
     */
    public detailsModel: any = {
        grouppanel2: new FormGroupPanelModel({ caption: '学历信息', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmdetail.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '职务信息', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmdetail.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel3: new FormGroupPanelModel({ caption: '所得荣誉', detailType: 'GROUPPANEL', name: 'grouppanel3', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmdetail.main_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel4: new FormGroupPanelModel({ caption: '合同信息', detailType: 'GROUPPANEL', name: 'grouppanel4', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmdetail.main_form', extractMode: 'ITEM', details: [] } })
, 
        group1: new FormGroupPanelModel({ caption: '人员明细表基本信息', detailType: 'GROUPPANEL', name: 'group1', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pcmdetail.main_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '人员明细表标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '人员明细表名称', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ygbh: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'ygbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonname: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zjhm: new FormItemModel({ caption: '证件号码', detailType: 'FORMITEM', name: 'zjhm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        csrq: new FormItemModel({ caption: '出生日期', detailType: 'FORMITEM', name: 'csrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jg: new FormItemModel({ caption: '籍贯', detailType: 'FORMITEM', name: 'jg', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nj: new FormItemModel({ caption: '年龄', detailType: 'FORMITEM', name: 'nj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xb: new FormItemModel({ caption: '性别', detailType: 'FORMITEM', name: 'xb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lxdh: new FormItemModel({ caption: '联系方式', detailType: 'FORMITEM', name: 'lxdh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hyzk: new FormItemModel({ caption: '婚姻状况', detailType: 'FORMITEM', name: 'hyzk', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        mz: new FormItemModel({ caption: '民族', detailType: 'FORMITEM', name: 'mz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hkxz: new FormItemModel({ caption: '户口性质', detailType: 'FORMITEM', name: 'hkxz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bz: new FormItemModel({ caption: '备注', detailType: 'FORMITEM', name: 'bz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hjdz: new FormItemModel({ caption: '户籍地址', detailType: 'FORMITEM', name: 'hjdz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimmajorsetypename: new FormItemModel({ caption: '所属业务系统', detailType: 'FORMITEM', name: 'pimmajorsetypename', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rzqd: new FormItemModel({ caption: '入职渠道', detailType: 'FORMITEM', name: 'rzqd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        yglx: new FormItemModel({ caption: '员工类型', detailType: 'FORMITEM', name: 'yglx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dyxlbyyx: new FormItemModel({ caption: '第一学历毕业院校', detailType: 'FORMITEM', name: 'dyxlbyyx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dyxljssj: new FormItemModel({ caption: '第一学历毕业时间', detailType: 'FORMITEM', name: 'dyxljssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zgxljssj: new FormItemModel({ caption: '最高学历毕业时间', detailType: 'FORMITEM', name: 'zgxljssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dyxlsxzy: new FormItemModel({ caption: '第一学历所学专业', detailType: 'FORMITEM', name: 'dyxlsxzy', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        firsteducation: new FormItemModel({ caption: '是否第一学历', detailType: 'FORMITEM', name: 'firsteducation', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sfzgxl: new FormItemModel({ caption: '是否最高学历', detailType: 'FORMITEM', name: 'sfzgxl', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zgxlsxzy: new FormItemModel({ caption: '最高学历所学专业', detailType: 'FORMITEM', name: 'zgxlsxzy', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zgxlbyyx: new FormItemModel({ caption: '最高学历毕业院校', detailType: 'FORMITEM', name: 'zgxlbyyx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xllx: new FormItemModel({ caption: '第一学历学习形式', detailType: 'FORMITEM', name: 'xllx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xxlb: new FormItemModel({ caption: '第一学历学校类别', detailType: 'FORMITEM', name: 'xxlb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sbcjd: new FormItemModel({ caption: '社保参缴地', detailType: 'FORMITEM', name: 'sbcjd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zzmm: new FormItemModel({ caption: '政治面貌', detailType: 'FORMITEM', name: 'zzmm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        px: new FormItemModel({ caption: '培训', detailType: 'FORMITEM', name: 'px', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bdwgznx: new FormItemModel({ caption: '本单位工作年限', detailType: 'FORMITEM', name: 'bdwgznx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        bjgznx: new FormItemModel({ caption: '局工作年限', detailType: 'FORMITEM', name: 'bjgznx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        careername: new FormItemModel({ caption: '专业技术资格（职称）', detailType: 'FORMITEM', name: 'careername', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zjxtgznx: new FormItemModel({ caption: '建筑系统工作年限', detailType: 'FORMITEM', name: 'zjxtgznx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        cjgzsj: new FormItemModel({ caption: '参加工作时间', detailType: 'FORMITEM', name: 'cjgzsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        tozjdate: new FormItemModel({ caption: '建筑系统工作时间', detailType: 'FORMITEM', name: 'tozjdate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dbdwsj: new FormItemModel({ caption: '本单位工作时间', detailType: 'FORMITEM', name: 'dbdwsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rank: new FormItemModel({ caption: '职级', detailType: 'FORMITEM', name: 'rank', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rdsj: new FormItemModel({ caption: '入党时间', detailType: 'FORMITEM', name: 'rdsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dzjbjsj: new FormItemModel({ caption: '局工作时间', detailType: 'FORMITEM', name: 'dzjbjsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gw: new FormItemModel({ caption: '岗位', detailType: 'FORMITEM', name: 'gw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gznx: new FormItemModel({ caption: '工作年限', detailType: 'FORMITEM', name: 'gznx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gwtype: new FormItemModel({ caption: '岗位类别', detailType: 'FORMITEM', name: 'gwtype', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jxkhcj: new FormItemModel({ caption: '绩效考核成绩（近两年）', detailType: 'FORMITEM', name: 'jxkhcj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zw: new FormItemModel({ caption: '职务', detailType: 'FORMITEM', name: 'zw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zcbh: new FormItemModel({ caption: '职称编号', detailType: 'FORMITEM', name: 'zcbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sfzckjs: new FormItemModel({ caption: '是否注册会计师', detailType: 'FORMITEM', name: 'sfzckjs', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgsectorname: new FormItemModel({ caption: '部门名称', detailType: 'FORMITEM', name: 'ormorgsectorname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimvocationalcatalogname: new FormItemModel({ caption: '执(职)业资格证书', detailType: 'FORMITEM', name: 'pimvocationalcatalogname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgname: new FormItemModel({ caption: '工作单位', detailType: 'FORMITEM', name: 'ormorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zgzsbh: new FormItemModel({ caption: '注册会计师证书编号', detailType: 'FORMITEM', name: 'zgzsbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimqualtypename: new FormItemModel({ caption: '岗位证书', detailType: 'FORMITEM', name: 'pimqualtypename', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        kstgkms: new FormItemModel({ caption: '注册会计师专业阶段考试已通过科目数', detailType: 'FORMITEM', name: 'kstgkms', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        qsrq: new FormItemModel({ caption: '签订日期', detailType: 'FORMITEM', name: 'qsrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jsrq: new FormItemModel({ caption: '结束日期', detailType: 'FORMITEM', name: 'jsrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        htqx: new FormItemModel({ caption: '合同期限', detailType: 'FORMITEM', name: 'htqx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        contracttype: new FormItemModel({ caption: '劳动合同性质', detailType: 'FORMITEM', name: 'contracttype', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        htsyq: new FormItemModel({ caption: '合同试用期', detailType: 'FORMITEM', name: 'htsyq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgsectorid: new FormItemModel({ caption: '部门标识', detailType: 'FORMITEM', name: 'ormorgsectorid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmdetailid: new FormItemModel({ caption: '人员明细表标识', detailType: 'FORMITEM', name: 'pcmdetailid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
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
     * 监控表单属性 zjhm 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zjhm')
    onZjhmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zjhm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 csrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.csrq')
    onCsrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'csrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jg 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.jg')
    onJgChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jg', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.nj')
    onNjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.xb')
    onXbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lxdh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.lxdh')
    onLxdhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lxdh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hyzk 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.hyzk')
    onHyzkChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hyzk', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 mz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.mz')
    onMzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hkxz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.hkxz')
    onHkxzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hkxz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bz')
    onBzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hjdz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.hjdz')
    onHjdzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hjdz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimmajorsetypename 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimmajorsetypename')
    onPimmajorsetypenameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimmajorsetypename', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rzqd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.rzqd')
    onRzqdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rzqd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 yglx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.yglx')
    onYglxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'yglx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dyxlbyyx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.dyxlbyyx')
    onDyxlbyyxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dyxlbyyx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dyxljssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.dyxljssj')
    onDyxljssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dyxljssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zgxljssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zgxljssj')
    onZgxljssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zgxljssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dyxlsxzy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.dyxlsxzy')
    onDyxlsxzyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dyxlsxzy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 firsteducation 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.firsteducation')
    onFirsteducationChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'firsteducation', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfzgxl 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfzgxl')
    onSfzgxlChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfzgxl', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zgxlsxzy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zgxlsxzy')
    onZgxlsxzyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zgxlsxzy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zgxlbyyx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zgxlbyyx')
    onZgxlbyyxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zgxlbyyx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xllx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.xllx')
    onXllxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xllx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xxlb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.xxlb')
    onXxlbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xxlb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sbcjd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sbcjd')
    onSbcjdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sbcjd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zzmm 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zzmm')
    onZzmmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zzmm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 px 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.px')
    onPxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'px', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bdwgznx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bdwgznx')
    onBdwgznxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bdwgznx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 bjgznx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.bjgznx')
    onBjgznxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'bjgznx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 careername 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.careername')
    onCareernameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'careername', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zjxtgznx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zjxtgznx')
    onZjxtgznxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zjxtgznx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cjgzsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.cjgzsj')
    onCjgzsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'cjgzsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 tozjdate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.tozjdate')
    onTozjdateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'tozjdate', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dbdwsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.dbdwsj')
    onDbdwsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dbdwsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rank 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.rank')
    onRankChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rank', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rdsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.rdsj')
    onRdsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rdsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dzjbjsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.dzjbjsj')
    onDzjbjsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dzjbjsj', newVal: newVal, oldVal: oldVal });
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
     * 监控表单属性 gznx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.gznx')
    onGznxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gznx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gwtype 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.gwtype')
    onGwtypeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gwtype', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jxkhcj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.jxkhcj')
    onJxkhcjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jxkhcj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zw')
    onZwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zcbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zcbh')
    onZcbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zcbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfzckjs 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.sfzckjs')
    onSfzckjsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfzckjs', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgsectorname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormorgsectorname')
    onOrmorgsectornameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgsectorname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimvocationalcatalogname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimvocationalcatalogname')
    onPimvocationalcatalognameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimvocationalcatalogname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormorgname')
    onOrmorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zgzsbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.zgzsbh')
    onZgzsbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zgzsbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimqualtypename 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pimqualtypename')
    onPimqualtypenameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimqualtypename', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 kstgkms 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.kstgkms')
    onKstgkmsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'kstgkms', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 qsrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.qsrq')
    onQsrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'qsrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jsrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.jsrq')
    onJsrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jsrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 htqx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.htqx')
    onHtqxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'htqx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 contracttype 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.contracttype')
    onContracttypeChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'contracttype', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 htsyq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.htsyq')
    onHtsyqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'htsyq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgsectorid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.ormorgsectorid')
    onOrmorgsectoridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgsectorid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmdetailid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MainBase
     */
    @Watch('data.pcmdetailid')
    onPcmdetailidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmdetailid', newVal: newVal, oldVal: oldVal });
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
        if(data.pcmdetail){
            Object.assign(this.context,{pcmdetail:data.pcmdetail})
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
        copyData.pcmdetail = copyData.srfkey;
        copyData.pcmdetailid = copyData.srfkey;
        Object.assign(this.context,{pcmdetail:copyData.pcmdetail})
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
        _this.$print({id:'pcmdetail_main',popTitle:'主编辑表单'});
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
            this.$Notice.error({ title: '错误', desc: 'PCMDETAILEditView视图表单loadAction参数未配置' });
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
            this.$Notice.error({ title: '错误', desc: 'PCMDETAILEditView视图表单loaddraftAction参数未配置' });
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
            if(data.pcmdetail){
                Object.assign(this.context,{pcmdetail:data.pcmdetail})
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
            this.$Notice.error({ title: '错误', desc: 'PCMDETAILEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PCMDETAILEditView视图表单'+actionName+'参数未配置' });
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
                this.$Notice.error({ title: '错误', desc: 'PCMDETAILEditView视图表单removeAction参数未配置' });
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
        if (!arg.pcmdetail || Object.is(arg.pcmdetail, '')) {
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