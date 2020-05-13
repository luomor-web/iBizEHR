<template>
    <i-form :model="this.data" class='app-form' ref='form'  id='form' style="">
    <input style="display:none;" />
    <row >
            
<div v-show="detailsModel.grouppanel1.visible">
    <app-form-group layoutType="TABLE_12COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel1.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel1')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <div v-show="detailsModel.grouppanel4.visible">
    <app-form-group layoutType="TABLE_12COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel4.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel4')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
            
    </row>
</app-form-group>

</div>
<div v-show="detailsModel.grouppanel2.visible">
    <app-form-group layoutType="TABLE_12COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel2.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel2')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.grouppanel9.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel9.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel9')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.ygbh.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='ygbh' :itemRules="this.rules.ygbh" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.ygbh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ygbh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ygbh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ygbh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zjlx.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='zjlx' :itemRules="this.rules.zjlx" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.zjlx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zjlx.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.zjlx" :data="data" :itemParam="{}" :disabled="detailsModel.zjlx.disabled"  tag='PIMCL_ZJLX' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.csrq.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='csrq' :itemRules="this.rules.csrq" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.csrq')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.csrq.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.csrq" :disabled="detailsModel.csrq.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.csrq = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xb.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='xb' :itemRules="this.rules.xb" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.xb')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xb.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.xb" :data="data" :itemParam="{}" :disabled="detailsModel.xb.disabled"  tag='PIMCL_XB' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel10.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel10.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel10')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pimpersonname.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='pimpersonname' :itemRules="this.rules.pimpersonname" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.pimpersonname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.pimpersonname"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.pimpersonname.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zjhm.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='zjhm' :itemRules="this.rules.zjhm" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.zjhm')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zjhm.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.zjhm"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.zjhm.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.nj.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='nj' :itemRules="this.rules.nj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.nj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.nj.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.nj"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.nj.disabled" type='number'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.xx.visible" :style="{}"  :lg="{ span: 24, offset: 0 }">
    <app-form-item name='xx' :itemRules="this.rules.xx" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.xx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.xx.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.xx" :data="data" :itemParam="{}" :disabled="detailsModel.xx.disabled"  tag='PIMCL_XX' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
<i-col v-show="detailsModel.grouppanel11.visible" :style="{}"  :sm="{ span: 8, offset: 0 }" :md="{ span: 8, offset: 0 }" :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-group layoutType="TABLE_24COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel11.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel11')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.zp.visible" :style="{}"  :lg="{ span: 8, offset: 0 }">
    <app-form-item name='zp' :itemRules="this.rules.zp" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.zp')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zp.error" :isEmptyCaption="false" labelPos="LEFT">
     <app-image-upload :multiple="false" :formState="formState" :ignorefieldvaluechange="ignorefieldvaluechange" @formitemvaluechange="onFormItemValueChange" :data="JSON.stringify(this.data)" name='zp' :value="data.zp" :disabled="detailsModel.zp.disabled" uploadparams='' exportparams='' :customparams="{}"></app-image-upload>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</i-col>
    
    </row>
</app-form-group>

</div>
<div v-show="detailsModel.grouppanel8.visible">
    <app-form-group layoutType="TABLE_12COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel8.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel8')" :isShowCaption="false" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.lxdh.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='lxdh' :itemRules="this.rules.lxdh" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.lxdh')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.lxdh.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.lxdh"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.lxdh.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.dzyx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='dzyx' :itemRules="this.rules.dzyx" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.dzyx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dzyx.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.dzyx"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.dzyx.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hyzk.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='hyzk' :itemRules="this.rules.hyzk" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.hyzk')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hyzk.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.hyzk" :data="data" :itemParam="{}" :disabled="detailsModel.hyzk.disabled"  tag='PIMCL_HY' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.mz.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='mz' :itemRules="this.rules.mz" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.mz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.mz.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.mz" :data="data" :itemParam="{}" :disabled="detailsModel.mz.disabled"  tag='PIMCL_NATION' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hklx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='hklx' :itemRules="this.rules.hklx" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.hklx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hklx.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.hklx" :data="data" :itemParam="{}" :disabled="detailsModel.hklx.disabled"  tag='PIMCL_HKLX' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.jg.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='jg' :itemRules="this.rules.jg" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.jg')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jg.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-autocomplete 
    :data="data"
    :disabled="detailsModel.jg.disabled" 
    name='jg'
    :context="context"
    :viewparams="viewparams"
    deMajorField='pimcityname'
    deKeyField='pimcity'
    :itemParam='{ }' 
    :service="service"
    :acParams="{ serviceName: 'PIMCITYService', interfaceName: 'FetchDefault'}"
    valueitem='' 
    :value="data.jg" 
    @formitemvaluechange="onFormItemValueChange"
    style="">
</app-autocomplete>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hjszd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='hjszd' :itemRules="this.rules.hjszd" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.hjszd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hjszd.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.hjszd" :data="data" :itemParam="{}" :disabled="detailsModel.hjszd.disabled"  tag='NATIVEPLACE' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.hjdz.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='hjdz' :itemRules="this.rules.hjdz" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.hjdz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hjdz.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-autocomplete 
    :data="data"
    :disabled="detailsModel.hjdz.disabled" 
    name='hjdz'
    :context="context"
    :viewparams="viewparams"
    deMajorField='pimcityname'
    deKeyField='pimcity'
    :itemParam='{ }' 
    :service="service"
    :acParams="{ serviceName: 'PIMCITYService', interfaceName: 'FetchDefault'}"
    valueitem='' 
    :value="data.hjdz" 
    @formitemvaluechange="onFormItemValueChange"
    style="">
</app-autocomplete>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.csd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='csd' :itemRules="this.rules.csd" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.csd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.csd.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-autocomplete 
    :data="data"
    :disabled="detailsModel.csd.disabled" 
    name='csd'
    :context="context"
    :viewparams="viewparams"
    deMajorField='pimcityname'
    deKeyField='pimcity'
    :itemParam='{ }' 
    :service="service"
    :acParams="{ serviceName: 'PIMCITYService', interfaceName: 'FetchDefault'}"
    valueitem='' 
    :value="data.csd" 
    @formitemvaluechange="onFormItemValueChange"
    style="">
</app-autocomplete>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.postaladdress.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='postaladdress' :itemRules="this.rules.postaladdress" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.postaladdress')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.postaladdress.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-autocomplete 
    :data="data"
    :disabled="detailsModel.postaladdress.disabled" 
    name='postaladdress'
    :context="context"
    :viewparams="viewparams"
    deMajorField='pimcityname'
    deKeyField='pimcity'
    :itemParam='{ }' 
    :service="service"
    :acParams="{ serviceName: 'PIMCITYService', interfaceName: 'FetchDefault'}"
    valueitem='' 
    :value="data.postaladdress" 
    @formitemvaluechange="onFormItemValueChange"
    style="">
</app-autocomplete>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sfdszn.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='sfdszn' :itemRules="this.rules.sfdszn" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.sfdszn')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sfdszn.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-radio-group v-model="data.sfdszn"  :disabled="detailsModel.sfdszn.disabled"  name="sfdszn" tag='PIMCL_SFLJ' codelistType='STATIC'  style=""></app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.ahtc.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='ahtc' :itemRules="this.rules.ahtc" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.ahtc')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ahtc.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.ahtc"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.ahtc.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rcxllx.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='rcxllx' :itemRules="this.rules.rcxllx" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.rcxllx')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rcxllx.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.rcxllx" :data="data" :itemParam="{}" :disabled="detailsModel.rcxllx.disabled"  tag='PCMCL_RCXLLX' codelistType='STATIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimmajorsetypename.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='pimmajorsetypename' :itemRules="this.rules.pimmajorsetypename" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.pimmajorsetypename')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimmajorsetypename.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :itemParam='{ }' 
  :disabled="detailsModel.pimmajorsetypename.disabled"
  name='pimmajorsetypename'
  deMajorField='pimmajorsetypename'
  deKeyField='pimmajorsetype'
  :service="service"
  :acParams="{ serviceName: 'PIMMAJORSETYPEService', interfaceName: 'FetchDefault'}"
  valueitem='pimmajorsetypeid' 
  :value="data.pimmajorsetypename" 
  editortype="" 
  :pickupView="{ viewname: 'pimmajorsetypepickup-view', title: $t('entities.pimmajorsetype.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimmajorsetypes', parameterName: 'pimmajorsetype' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.pcmrcxlname.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='pcmrcxlname' :itemRules="this.rules.pcmrcxlname" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.pcmrcxlname')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pcmrcxlname.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :itemParam='{ }' 
  :disabled="detailsModel.pcmrcxlname.disabled"
  name='pcmrcxlname'
  deMajorField='rcxlmc'
  deKeyField='pcmrcxl'
  :service="service"
  :acParams="{ serviceName: 'PCMRCXLService', interfaceName: 'FetchRCXLPPXLLX'}"
  valueitem='pcmrcxlid' 
  :value="data.pcmrcxlname" 
  editortype="" 
  :pickupView="{ viewname: 'pcmrcxlpickup-view', title: $t('entities.pcmrcxl.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pcmrcxls', parameterName: 'pcmrcxl' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.jkzk.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='jkzk' :itemRules="this.rules.jkzk" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.jkzk')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.jkzk.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.jkzk"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.jkzk.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</div>
    
    </row>
</app-form-group>

</div>
<div v-show="detailsModel.grouppanel6.visible">
    <app-form-group layoutType="TABLE_12COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel6.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel6')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.zzmm.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='zzmm' :itemRules="this.rules.zzmm" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.zzmm')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zzmm.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.zzmm" :data="data" :itemParam="{}" :disabled="detailsModel.zzmm.disabled"  tag='PIMCL_ZZMM' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rtsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='rtsj' :itemRules="this.rules.rtsj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.rtsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rtsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.rtsj" :disabled="detailsModel.rtsj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.rtsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rdsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='rdsj' :itemRules="this.rules.rdsj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.rdsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rdsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.rdsj" :disabled="detailsModel.rdsj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.rdsj = val1 }"></date-picker>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</div>
<div v-show="detailsModel.grouppanel5.visible">
    <app-form-group layoutType="TABLE_12COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel5.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel5')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.ygzt.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='ygzt' :itemRules="this.rules.ygzt" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.ygzt')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.ygzt.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.ygzt" :data="data" :itemParam="{}" :disabled="detailsModel.ygzt.disabled"  tag='PIMCL_YGZT' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.workstate.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='workstate' :itemRules="this.rules.workstate" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.workstate')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.workstate.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.workstate" :data="data" :itemParam="{}" :disabled="detailsModel.workstate.disabled"  tag='WORKSTATE' codelistType='STATIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rzqd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='rzqd' :itemRules="this.rules.rzqd" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.rzqd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rzqd.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.rzqd" :data="data" :itemParam="{}" :disabled="detailsModel.rzqd.disabled"  tag='PIMCL_RZLB' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.rank.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='rank' :itemRules="this.rules.rank" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.rank')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.rank.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.rank" :data="data" :itemParam="{}" :disabled="detailsModel.rank.disabled"  tag='PIMCL_RANK' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.zj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='zj' :itemRules="this.rules.zj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.zj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.zj.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.zj" :data="data" :itemParam="{}" :disabled="detailsModel.zj.disabled"  tag='PIMCL_ZJ' codelistType='DYNAMIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.cjgzsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='cjgzsj' :itemRules="this.rules.cjgzsj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.cjgzsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.cjgzsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.cjgzsj" :disabled="detailsModel.cjgzsj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.cjgzsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.tozjdate.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='tozjdate' :itemRules="this.rules.tozjdate" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.tozjdate')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.tozjdate.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.tozjdate" :disabled="detailsModel.tozjdate.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.tozjdate = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.dzjbjsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='dzjbjsj' :itemRules="this.rules.dzjbjsj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.dzjbjsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dzjbjsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.dzjbjsj" :disabled="detailsModel.dzjbjsj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.dzjbjsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.dbdwsj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='dbdwsj' :itemRules="this.rules.dbdwsj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.dbdwsj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.dbdwsj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.dbdwsj" :disabled="detailsModel.dbdwsj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.dbdwsj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gzzt.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='gzzt' :itemRules="this.rules.gzzt" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.gzzt')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gzzt.error" :isEmptyCaption="false" labelPos="LEFT">
     <dropdown-list v-model="data.gzzt" :data="data" :itemParam="{}" :disabled="detailsModel.gzzt.disabled"  tag='PIMCL_GZZT' codelistType='STATIC' placeholder='请选择...' style=""></dropdown-list>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gzzz.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='gzzz' :itemRules="this.rules.gzzz" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.gzzz')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gzzz.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.gzzz"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.gzzz.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gzbm.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='gzbm' :itemRules="this.rules.gzbm" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.gzbm')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gzbm.error" :isEmptyCaption="false" labelPos="LEFT">
    <input-box v-model="data.gzbm"  @enter="onEnter($event)"   unit=""  :disabled="detailsModel.gzbm.disabled" type='text'  style=""></input-box>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gzkssj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='gzkssj' :itemRules="this.rules.gzkssj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.gzkssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gzkssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.gzkssj" :disabled="detailsModel.gzkssj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.gzkssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.gzjssj.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='gzjssj' :itemRules="this.rules.gzjssj" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.gzjssj')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.gzjssj.error" :isEmptyCaption="false" labelPos="LEFT">
    <date-picker type="date" :transfer="true" format="yyyy-MM-dd" placeholder="请选择时间..." :value="data.gzjssj" :disabled="detailsModel.gzjssj.disabled" style="min-width: 150px; width:100px;width:100%;" @on-change="(val1, val2) => { this.data.gzjssj = val1 }"></date-picker>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.sgyy.visible" :style="{}"  :lg="{ span: 24, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='sgyy' :itemRules="this.rules.sgyy" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.sgyy')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.sgyy.error" :isEmptyCaption="false" labelPos="LEFT">
    <div class="ivu-input-wrapper ivu-input-wrapper-default ivu-input-type">
    <textarea class="ivu-input" v-model="data.sgyy" :disabled="detailsModel.sgyy.disabled" style=""></textarea>
</div>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</div>
<div v-show="detailsModel.grouppanel7.visible">
    <app-form-group layoutType="TABLE_12COL" titleStyle="" class='' uiActionGroup="detailsModel.grouppanel7.uiActionGroup" @groupuiactionclick="groupUIActionClick($event)" :caption="$t('entities.pimperson.ryinfoform_form.details.grouppanel7')" :isShowCaption="true" uiStyle="DEFAULT" :titleBarCloseMode="0" :isInfoGroupMode="false" >    
    <row>
        <i-col v-show="detailsModel.pimpersonname2.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='pimpersonname2' :itemRules="this.rules.pimpersonname2" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.pimpersonname2')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname2.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :itemParam='{ }' 
  :disabled="detailsModel.pimpersonname2.disabled"
  name='pimpersonname2'
  deMajorField='pimpersonname'
  deKeyField='pimperson'
  :service="service"
  :acParams="{ serviceName: 'PIMPERSONService', interfaceName: 'FetchDefault'}"
  valueitem='pimpersonid2' 
  :value="data.pimpersonname2" 
  editortype="" 
  :pickupView="{ viewname: 'pimpersonpickup-view', title: $t('entities.pimperson.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimpeople', parameterName: 'pimperson' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.pimpersonname3.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='pimpersonname3' :itemRules="this.rules.pimpersonname3" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.pimpersonname3')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.pimpersonname3.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-picker 
  :formState="formState"
  :data="data"
  :context="context"
  :viewparams="viewparams"
  :itemParam='{ }' 
  :disabled="detailsModel.pimpersonname3.disabled"
  name='pimpersonname3'
  deMajorField='pimpersonname'
  deKeyField='pimperson'
  :service="service"
  :acParams="{ serviceName: 'PIMPERSONService', interfaceName: 'FetchDefault'}"
  valueitem='pimpersonid3' 
  :value="data.pimpersonname3" 
  editortype="" 
  :pickupView="{ viewname: 'pimpersonpickup-view', title: $t('entities.pimperson.views.pickupview.title'), deResParameters: [], parameters: [{ pathName: 'pimpeople', parameterName: 'pimperson' }, { pathName: 'pickupview', parameterName: 'pickupview' } ], placement:'' }"
  style=""  
  @formitemvaluechange="onFormItemValueChange">
</app-picker>

</app-form-item>

</i-col>
<i-col v-show="detailsModel.hmd.visible" :style="{}"  :lg="{ span: 8, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='hmd' :itemRules="this.rules.hmd" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.hmd')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.hmd.error" :isEmptyCaption="false" labelPos="LEFT">
    <app-radio-group v-model="data.hmd"  :disabled="detailsModel.hmd.disabled"  name="hmd" tag='YesNo' codelistType='STATIC'  style=""></app-radio-group>
</app-form-item>

</i-col>
<i-col v-show="detailsModel.blacklistreasons.visible" :style="{}"  :lg="{ span: 24, offset: 0 }" :xl="{ span: 8, offset: 0 }">
    <app-form-item name='blacklistreasons' :itemRules="this.rules.blacklistreasons" class='' :caption="$t('entities.pimperson.ryinfoform_form.details.blacklistreasons')" uiStyle="DEFAULT" :labelWidth="130" :isShowCaption="true" :error="detailsModel.blacklistreasons.error" :isEmptyCaption="false" labelPos="LEFT">
    <div class="ivu-input-wrapper ivu-input-wrapper-default ivu-input-type">
    <textarea class="ivu-input" v-model="data.blacklistreasons" :disabled="detailsModel.blacklistreasons.disabled" style=""></textarea>
</div>
</app-form-item>

</i-col>
    
    </row>
</app-form-group>

</div>


    </row>
</i-form>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import PIMPERSONService from '@/service/pimperson/pimperson-service';
import RYInfoFormService from './ryinfo-form-form-service';

import { FormButtonModel, FormPageModel, FormItemModel, FormDRUIPartModel, FormPartModel, FormGroupPanelModel, FormIFrameModel, FormRowItemModel, FormTabPageModel, FormTabPanelModel, FormUserControlModel } from '@/model/form-detail';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';


@Component({
    components: {
      
    }
})
export default class RYInfoFormBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof RYInfoForm
     */
    @Prop() protected viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof RYInfoForm
     */
    @Prop() protected context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof RYInfoForm
     */
    @Prop() protected viewparams: any;

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof RYInfoForm
     */
    protected viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof RYInfoForm
     */
    protected getControlType(): string {
        return 'FORM'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof RYInfoForm
     */    
    protected counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {RYInfoFormService}
     * @memberof RYInfoForm
     */
    protected service: RYInfoFormService = new RYInfoFormService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {PIMPERSONService}
     * @memberof RYInfoForm
     */
    protected appEntityService: PIMPERSONService = new PIMPERSONService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof RYInfoForm
     */
    protected closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof RYInfoForm
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
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof RYInfoForm
     */
    public getDatas(): any[] {
        return [this.data];
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof RYInfoForm
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 是否默认保存
     *
     * @type {boolean}
     * @memberof RYInfoForm
     */
    @Prop({ default: false }) protected autosave?: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof RYInfoForm
     */
    @Prop({ default: true }) protected showBusyIndicator?: boolean;

    /**
     * 部件行为--submit
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected WFSubmitAction!: string;
    
    /**
     * 部件行为--start
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected WFStartAction!: string;
    
    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected updateAction!: string;
    
    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected removeAction!: string;
    
    /**
     * 部件行为--loaddraft
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected loaddraftAction!: string;
    
    /**
     * 部件行为--load
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected loadAction!: string;
    
    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected createAction!: string;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected searchAction!: string;

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof RYInfoForm
     */
    @Prop() protected viewtag!: string;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof RYInfoForm
     */
    protected formState: Subject<any> = new Subject();

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof RYInfoForm
     */
    protected ignorefieldvaluechange: boolean = false;

    /**
     * 数据变化
     *
     * @private
     * @type {Subject<any>}
     * @memberof RYInfoForm
     */
    private dataChang: Subject<any> = new Subject();

    /**
     * 视图状态事件
     *
     * @private
     * @type {(Subscription | undefined)}
     * @memberof RYInfoForm
     */
    private dataChangEvent: Subscription | undefined;

    /**
     * 原始数据
     *
     * @private
     * @type {*}
     * @memberof RYInfoForm
     */
    private oldData: any = {};

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof RYInfoForm
     */
    protected data: any = {
        srfupdatedate: null,
        srforikey: null,
        srfkey: null,
        srfmajortext: null,
        srftempmode: null,
        srfuf: null,
        srfdeid: null,
        srfsourcekey: null,
        srfip_ygbh: null,
        srfip_zjlx: null,
        srfip_pimpersonname: null,
        srfip_zjhm: null,
        orgid: null,
        orgsectorid: null,
        pimpersonid2: null,
        pimpersonid: null,
        ygbh: null,
        zjlx: null,
        csrq: null,
        xb: null,
        pimpersonname: null,
        zjhm: null,
        nj: null,
        xx: null,
        zp: null,
        lxdh: null,
        dzyx: null,
        hyzk: null,
        mz: null,
        hklx: null,
        jg: null,
        hjszd: null,
        hjdz: null,
        csd: null,
        postaladdress: null,
        sfdszn: null,
        ahtc: null,
        rcxllx: null,
        pimmajorsetypename: null,
        pcmrcxlname: null,
        jkzk: null,
        jlczz: null,
        zzmm: null,
        rtsj: null,
        rdsj: null,
        yglx: null,
        ygzt: null,
        workstate: null,
        rzqd: null,
        ormorgid: null,
        ormorgname: null,
        ormorgsectorid: null,
        ormorgsectorname: null,
        rank: null,
        zw: null,
        gw: null,
        zj: null,
        cjgzsj: null,
        tozjdate: null,
        dzjbjsj: null,
        dbdwsj: null,
        gzzt: null,
        gzzz: null,
        gzbm: null,
        gzkssj: null,
        gzjssj: null,
        sgyy: null,
        pimpersonname2: null,
        pimpersonname3: null,
        sftberp: null,
        hmd: null,
        blacklistreasons: null,
        pimpersonid3: null,
        pcmrcxlid: null,
        pimmajorsetypeid: null,
        pimperson:null,
    };

    /**
      * 当前执行的行为逻辑
      *
      * @type {string}
      * @memberof RYInfoForm
      */
    protected currentAction: string = "";

    /**
      * 关系界面计数器
      *
      * @type {number}
      * @memberof RYInfoForm
      */
    protected drcounter: number = 0;

    /**
      * 需要等待关系界面保存时，第一次调用save参数的备份
      *
      * @type {number}
      * @memberof RYInfoForm
      */
    protected drsaveopt: any = {};

    /**
      * 表单保存回调存储对象
      *
      * @type {any}
      * @memberof RYInfoForm
      */
    protected saveState:any ;

    /**
     * 属性值规则
     *
     * @type {*}
     * @memberof RYInfoForm
     */
    protected rules: any = {
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
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        srfmajortext: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
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
        srfip_ygbh: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfip_zjlx: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfip_pimpersonname: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        srfip_zjhm: [
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: ' 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: ' 值不能为空', trigger: 'blur' },
        ],
        orgid: [
            { type: 'string', message: '组织ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织ID 值不能为空', trigger: 'blur' },
        ],
        orgsectorid: [
            { type: 'string', message: '部门ID 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门ID 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门ID 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门ID 值不能为空', trigger: 'blur' },
        ],
        pimpersonid2: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        pimpersonid: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        ygbh: [
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工编号 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '员工编号 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '员工编号 值不能为空', trigger: 'blur' },
        ],
        zjlx: [
            { type: 'string', message: '证件类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件类型 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '证件类型 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '证件类型 值不能为空', trigger: 'blur' },
        ],
        csrq: [
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '出生日期 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '出生日期 值不能为空', trigger: 'blur' },
        ],
        xb: [
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '性别 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '性别 值不能为空', trigger: 'blur' },
        ],
        pimpersonname: [
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工姓名 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '员工姓名 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '员工姓名 值不能为空', trigger: 'blur' },
        ],
        zjhm: [
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '证件号码 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '证件号码 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '证件号码 值不能为空', trigger: 'blur' },
        ],
        nj: [
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '年龄 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '年龄 值不能为空', trigger: 'blur' },
        ],
        xx: [
            { type: 'string', message: '血型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '血型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '血型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '血型 值不能为空', trigger: 'blur' },
        ],
        zp: [
            { type: 'string', message: '照片 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '照片 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '照片 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '照片 值不能为空', trigger: 'blur' },
        ],
        lxdh: [
            { type: 'string', message: '手机号码 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '手机号码 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '手机号码 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '手机号码 值不能为空', trigger: 'blur' },
        ],
        dzyx: [
            { type: 'string', message: '电子邮箱 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '电子邮箱 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '电子邮箱 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '电子邮箱 值不能为空', trigger: 'blur' },
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
        hklx: [
            { type: 'string', message: '户口类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '户口类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '户口类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '户口类型 值不能为空', trigger: 'blur' },
        ],
        jg: [
            { type: 'string', message: '籍贯 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '籍贯 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '籍贯 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '籍贯 值不能为空', trigger: 'blur' },
        ],
        hjszd: [
            { type: 'string', message: '户籍所在地 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '户籍所在地 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '户籍所在地 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '户籍所在地 值不能为空', trigger: 'blur' },
        ],
        hjdz: [
            { type: 'string', message: '户籍地址 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '户籍地址 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '户籍地址 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '户籍地址 值不能为空', trigger: 'blur' },
        ],
        csd: [
            { type: 'string', message: '出生地 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '出生地 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '出生地 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '出生地 值不能为空', trigger: 'blur' },
        ],
        postaladdress: [
            { type: 'string', message: '通讯地址 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '通讯地址 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '通讯地址 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '通讯地址 值不能为空', trigger: 'blur' },
        ],
        sfdszn: [
            { type: 'string', message: '有独生子女证 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '有独生子女证 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '有独生子女证 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '有独生子女证 值不能为空', trigger: 'blur' },
        ],
        ahtc: [
            { type: 'string', message: '爱好特长 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '爱好特长 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '爱好特长 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '爱好特长 值不能为空', trigger: 'blur' },
        ],
        rcxllx: [
            { type: 'string', message: '人才序列类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人才序列类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人才序列类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人才序列类型 值不能为空', trigger: 'blur' },
        ],
        pimmajorsetypename: [
            { type: 'string', message: '专业序列类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '专业序列类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '专业序列类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '专业序列类型 值不能为空', trigger: 'blur' },
        ],
        pcmrcxlname: [
            { type: 'string', message: '人才序列 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人才序列 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人才序列 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人才序列 值不能为空', trigger: 'blur' },
        ],
        jkzk: [
            { type: 'string', message: '健康状况 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '健康状况 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '健康状况 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '健康状况 值不能为空', trigger: 'blur' },
        ],
        jlczz: [
            { type: 'string', message: '记录操作者 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '记录操作者 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '记录操作者 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '记录操作者 值不能为空', trigger: 'blur' },
        ],
        zzmm: [
            { type: 'string', message: '政治面貌 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '政治面貌 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '政治面貌 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '政治面貌 值不能为空', trigger: 'blur' },
        ],
        rtsj: [
            { type: 'string', message: '入团时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '入团时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '入团时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '入团时间 值不能为空', trigger: 'blur' },
        ],
        rdsj: [
            { type: 'string', message: '入党时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '入党时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '入党时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '入党时间 值不能为空', trigger: 'blur' },
        ],
        yglx: [
            { type: 'string', message: '员工类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工类型 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '员工类型 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '员工类型 值不能为空', trigger: 'blur' },
        ],
        ygzt: [
            { type: 'string', message: '员工状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '员工状态 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '员工状态 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '员工状态 值不能为空', trigger: 'blur' },
        ],
        workstate: [
            { type: 'string', message: '工作状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '工作状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '工作状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '工作状态 值不能为空', trigger: 'blur' },
        ],
        rzqd: [
            { type: 'string', message: '入职渠道 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '入职渠道 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '入职渠道 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '入职渠道 值不能为空', trigger: 'blur' },
        ],
        ormorgid: [
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织标识 值不能为空', trigger: 'blur' },
        ],
        ormorgname: [
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '组织 值不能为空', trigger: 'blur' },
        ],
        ormorgsectorid: [
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门标识 值不能为空', trigger: 'blur' },
        ],
        ormorgsectorname: [
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '部门 值不能为空', trigger: 'blur' },
        ],
        rank: [
            { type: 'string', message: '职级 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职级 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职级 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职级 值不能为空', trigger: 'blur' },
        ],
        zw: [
            { type: 'string', message: '职务 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '职务 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '职务 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '职务 值不能为空', trigger: 'blur' },
        ],
        gw: [
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '岗位 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '岗位 值不能为空', trigger: 'blur' },
        ],
        zj: [
            { type: 'string', message: '专家类型 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '专家类型 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '专家类型 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '专家类型 值不能为空', trigger: 'blur' },
        ],
        cjgzsj: [
            { type: 'string', message: '参加工作时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '参加工作时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '参加工作时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '参加工作时间 值不能为空', trigger: 'blur' },
        ],
        tozjdate: [
            { type: 'string', message: '到中建系统时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '到中建系统时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '到中建系统时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '到中建系统时间 值不能为空', trigger: 'blur' },
        ],
        dzjbjsj: [
            { type: 'string', message: '到局时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '到局时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '到局时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '到局时间 值不能为空', trigger: 'blur' },
        ],
        dbdwsj: [
            { type: 'string', message: '到本单位时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '到本单位时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '到本单位时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '到本单位时间 值不能为空', trigger: 'blur' },
        ],
        gzzt: [
            { type: 'string', message: '挂职状态 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '挂职状态 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '挂职状态 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '挂职状态 值不能为空', trigger: 'blur' },
        ],
        gzzz: [
            { type: 'string', message: '挂职组织 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '挂职组织 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '挂职组织 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '挂职组织 值不能为空', trigger: 'blur' },
        ],
        gzbm: [
            { type: 'string', message: '挂职部门 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '挂职部门 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '挂职部门 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '挂职部门 值不能为空', trigger: 'blur' },
        ],
        gzkssj: [
            { type: 'string', message: '挂职开始时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '挂职开始时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '挂职开始时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '挂职开始时间 值不能为空', trigger: 'blur' },
        ],
        gzjssj: [
            { type: 'string', message: '挂职结束时间 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '挂职结束时间 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '挂职结束时间 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '挂职结束时间 值不能为空', trigger: 'blur' },
        ],
        sgyy: [
            { type: 'string', message: '身故原因 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '身故原因 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '身故原因 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '身故原因 值不能为空', trigger: 'blur' },
        ],
        pimpersonname2: [
            { type: 'string', message: '思想导师 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '思想导师 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '思想导师 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '思想导师 值不能为空', trigger: 'blur' },
        ],
        pimpersonname3: [
            { type: 'string', message: '业务导师 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '业务导师 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '业务导师 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '业务导师 值不能为空', trigger: 'blur' },
        ],
        sftberp: [
            { type: 'string', message: '同步ERP 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '同步ERP 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '同步ERP 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '同步ERP 值不能为空', trigger: 'blur' },
        ],
        hmd: [
            { type: 'number', message: '列入黑名单 值必须为数值类型', trigger: 'change' },
            { type: 'number', message: '列入黑名单 值必须为数值类型', trigger: 'blur' },
            { required: false, type: 'number', message: '列入黑名单 值不能为空', trigger: 'change' },
            { required: false, type: 'number', message: '列入黑名单 值不能为空', trigger: 'blur' },
        ],
        blacklistreasons: [
            { type: 'string', message: '黑名单原因 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '黑名单原因 值必须为字符串类型', trigger: 'blur' },
            { required: true, type: 'string', message: '黑名单原因 值不能为空', trigger: 'change' },
            { required: true, type: 'string', message: '黑名单原因 值不能为空', trigger: 'blur' },
        ],
        pimpersonid3: [
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人员信息标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人员信息标识 值不能为空', trigger: 'blur' },
        ],
        pcmrcxlid: [
            { type: 'string', message: '人才序列标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '人才序列标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '人才序列标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '人才序列标识 值不能为空', trigger: 'blur' },
        ],
        pimmajorsetypeid: [
            { type: 'string', message: '专业序列类型标识 值必须为字符串类型', trigger: 'change' },
            { type: 'string', message: '专业序列类型标识 值必须为字符串类型', trigger: 'blur' },
            { required: false, type: 'string', message: '专业序列类型标识 值不能为空', trigger: 'change' },
            { required: false, type: 'string', message: '专业序列类型标识 值不能为空', trigger: 'blur' },
        ],
    }

    /**
     * 详情模型集合
     *
     * @type {*}
     * @memberof RYInfoForm
     */
    protected detailsModel: any = {
        grouppanel4: new FormGroupPanelModel({ caption: '', detailType: 'GROUPPANEL', name: 'grouppanel4', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel9: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel9', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel10: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel10', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel11: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel11', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel2: new FormGroupPanelModel({ caption: '分组面板', detailType: 'GROUPPANEL', name: 'grouppanel2', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel8: new FormGroupPanelModel({ caption: '相关信息', detailType: 'GROUPPANEL', name: 'grouppanel8', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel1: new FormGroupPanelModel({ caption: '基本信息', detailType: 'GROUPPANEL', name: 'grouppanel1', visible: true, isShowCaption: false, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel6: new FormGroupPanelModel({ caption: '政治面貌', detailType: 'GROUPPANEL', name: 'grouppanel6', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel5: new FormGroupPanelModel({ caption: '职务相关', detailType: 'GROUPPANEL', name: 'grouppanel5', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        grouppanel7: new FormGroupPanelModel({ caption: '其他信息', detailType: 'GROUPPANEL', name: 'grouppanel7', visible: true, isShowCaption: true, form: this, uiActionGroup: { caption: '', langbase: 'entities.pimperson.ryinfoform_form', extractMode: 'ITEM', details: [] } })
, 
        formpage1: new FormPageModel({ caption: '基本信息', detailType: 'FORMPAGE', name: 'formpage1', visible: true, isShowCaption: true, form: this })
, 
        srfupdatedate: new FormItemModel({ caption: '更新时间', detailType: 'FORMITEM', name: 'srfupdatedate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srforikey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srforikey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfkey: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'srfkey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfmajortext: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'srfmajortext', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srftempmode: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srftempmode', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfuf: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfuf', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfdeid: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfdeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfsourcekey: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfsourcekey', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfip_ygbh: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfip_ygbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfip_zjlx: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfip_zjlx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfip_pimpersonname: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfip_pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        srfip_zjhm: new FormItemModel({ caption: '', detailType: 'FORMITEM', name: 'srfip_zjhm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgid: new FormItemModel({ caption: '组织ID', detailType: 'FORMITEM', name: 'orgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        orgsectorid: new FormItemModel({ caption: '部门ID', detailType: 'FORMITEM', name: 'orgsectorid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonid2: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid2', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonid: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ygbh: new FormItemModel({ caption: '员工编号', detailType: 'FORMITEM', name: 'ygbh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zjlx: new FormItemModel({ caption: '证件类型', detailType: 'FORMITEM', name: 'zjlx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        csrq: new FormItemModel({ caption: '出生日期', detailType: 'FORMITEM', name: 'csrq', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        xb: new FormItemModel({ caption: '性别', detailType: 'FORMITEM', name: 'xb', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonname: new FormItemModel({ caption: '员工姓名', detailType: 'FORMITEM', name: 'pimpersonname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zjhm: new FormItemModel({ caption: '证件号码', detailType: 'FORMITEM', name: 'zjhm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        nj: new FormItemModel({ caption: '年龄', detailType: 'FORMITEM', name: 'nj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        xx: new FormItemModel({ caption: '血型', detailType: 'FORMITEM', name: 'xx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zp: new FormItemModel({ caption: '照片', detailType: 'FORMITEM', name: 'zp', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        lxdh: new FormItemModel({ caption: '手机号码', detailType: 'FORMITEM', name: 'lxdh', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dzyx: new FormItemModel({ caption: '电子邮箱', detailType: 'FORMITEM', name: 'dzyx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hyzk: new FormItemModel({ caption: '婚姻状况', detailType: 'FORMITEM', name: 'hyzk', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        mz: new FormItemModel({ caption: '民族', detailType: 'FORMITEM', name: 'mz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hklx: new FormItemModel({ caption: '户口类型', detailType: 'FORMITEM', name: 'hklx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jg: new FormItemModel({ caption: '籍贯', detailType: 'FORMITEM', name: 'jg', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hjszd: new FormItemModel({ caption: '户籍所在地', detailType: 'FORMITEM', name: 'hjszd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hjdz: new FormItemModel({ caption: '户籍地址', detailType: 'FORMITEM', name: 'hjdz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        csd: new FormItemModel({ caption: '出生地', detailType: 'FORMITEM', name: 'csd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        postaladdress: new FormItemModel({ caption: '通讯地址', detailType: 'FORMITEM', name: 'postaladdress', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sfdszn: new FormItemModel({ caption: '有独生子女证', detailType: 'FORMITEM', name: 'sfdszn', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ahtc: new FormItemModel({ caption: '爱好特长', detailType: 'FORMITEM', name: 'ahtc', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rcxllx: new FormItemModel({ caption: '人才序列类型', detailType: 'FORMITEM', name: 'rcxllx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimmajorsetypename: new FormItemModel({ caption: '专业序列类型', detailType: 'FORMITEM', name: 'pimmajorsetypename', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmrcxlname: new FormItemModel({ caption: '人才序列', detailType: 'FORMITEM', name: 'pcmrcxlname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jkzk: new FormItemModel({ caption: '健康状况', detailType: 'FORMITEM', name: 'jkzk', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        jlczz: new FormItemModel({ caption: '记录操作者', detailType: 'FORMITEM', name: 'jlczz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        zzmm: new FormItemModel({ caption: '政治面貌', detailType: 'FORMITEM', name: 'zzmm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rtsj: new FormItemModel({ caption: '入团时间', detailType: 'FORMITEM', name: 'rtsj', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rdsj: new FormItemModel({ caption: '入党时间', detailType: 'FORMITEM', name: 'rdsj', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        yglx: new FormItemModel({ caption: '员工类型', detailType: 'FORMITEM', name: 'yglx', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ygzt: new FormItemModel({ caption: '员工状态', detailType: 'FORMITEM', name: 'ygzt', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        workstate: new FormItemModel({ caption: '工作状态', detailType: 'FORMITEM', name: 'workstate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        rzqd: new FormItemModel({ caption: '入职渠道', detailType: 'FORMITEM', name: 'rzqd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgid: new FormItemModel({ caption: '组织标识', detailType: 'FORMITEM', name: 'ormorgid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgname: new FormItemModel({ caption: '组织', detailType: 'FORMITEM', name: 'ormorgname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        ormorgsectorid: new FormItemModel({ caption: '部门标识', detailType: 'FORMITEM', name: 'ormorgsectorid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        ormorgsectorname: new FormItemModel({ caption: '部门', detailType: 'FORMITEM', name: 'ormorgsectorname', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        rank: new FormItemModel({ caption: '职级', detailType: 'FORMITEM', name: 'rank', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        zw: new FormItemModel({ caption: '职务', detailType: 'FORMITEM', name: 'zw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        gw: new FormItemModel({ caption: '岗位', detailType: 'FORMITEM', name: 'gw', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 0 })
, 
        zj: new FormItemModel({ caption: '专家类型', detailType: 'FORMITEM', name: 'zj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        cjgzsj: new FormItemModel({ caption: '参加工作时间', detailType: 'FORMITEM', name: 'cjgzsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        tozjdate: new FormItemModel({ caption: '到中建系统时间', detailType: 'FORMITEM', name: 'tozjdate', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dzjbjsj: new FormItemModel({ caption: '到局时间', detailType: 'FORMITEM', name: 'dzjbjsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        dbdwsj: new FormItemModel({ caption: '到本单位时间', detailType: 'FORMITEM', name: 'dbdwsj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gzzt: new FormItemModel({ caption: '挂职状态', detailType: 'FORMITEM', name: 'gzzt', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gzzz: new FormItemModel({ caption: '挂职组织', detailType: 'FORMITEM', name: 'gzzz', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gzbm: new FormItemModel({ caption: '挂职部门', detailType: 'FORMITEM', name: 'gzbm', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gzkssj: new FormItemModel({ caption: '挂职开始时间', detailType: 'FORMITEM', name: 'gzkssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        gzjssj: new FormItemModel({ caption: '挂职结束时间', detailType: 'FORMITEM', name: 'gzjssj', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sgyy: new FormItemModel({ caption: '身故原因', detailType: 'FORMITEM', name: 'sgyy', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonname2: new FormItemModel({ caption: '思想导师', detailType: 'FORMITEM', name: 'pimpersonname2', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonname3: new FormItemModel({ caption: '业务导师', detailType: 'FORMITEM', name: 'pimpersonname3', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        sftberp: new FormItemModel({ caption: '同步ERP', detailType: 'FORMITEM', name: 'sftberp', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        hmd: new FormItemModel({ caption: '列入黑名单', detailType: 'FORMITEM', name: 'hmd', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        blacklistreasons: new FormItemModel({ caption: '黑名单原因', detailType: 'FORMITEM', name: 'blacklistreasons', visible: false, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimpersonid3: new FormItemModel({ caption: '人员信息标识', detailType: 'FORMITEM', name: 'pimpersonid3', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pcmrcxlid: new FormItemModel({ caption: '人才序列标识', detailType: 'FORMITEM', name: 'pcmrcxlid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
        pimmajorsetypeid: new FormItemModel({ caption: '专业序列类型标识', detailType: 'FORMITEM', name: 'pimmajorsetypeid', visible: true, isShowCaption: true, form: this, disabled: false, enableCond: 3 })
, 
    };

    /**
     * 监控表单属性 srfupdatedate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
     */
    @Watch('data.srfsourcekey')
    onSrfsourcekeyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfsourcekey', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfip_ygbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.srfip_ygbh')
    onSrfip_ygbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfip_ygbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfip_zjlx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.srfip_zjlx')
    onSrfip_zjlxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfip_zjlx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfip_pimpersonname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.srfip_pimpersonname')
    onSrfip_pimpersonnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfip_pimpersonname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 srfip_zjhm 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.srfip_zjhm')
    onSrfip_zjhmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'srfip_zjhm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.orgid')
    onOrgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 orgsectorid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.orgsectorid')
    onOrgsectoridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'orgsectorid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonid2 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pimpersonid2')
    onPimpersonid2Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonid2', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pimpersonid')
    onPimpersonidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ygbh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.ygbh')
    onYgbhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ygbh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zjlx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.zjlx')
    onZjlxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zjlx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 csrq 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.csrq')
    onCsrqChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'csrq', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xb 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.xb')
    onXbChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xb', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
     */
    @Watch('data.zjhm')
    onZjhmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zjhm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 nj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.nj')
    onNjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'nj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 xx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.xx')
    onXxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'xx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zp 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.zp')
    onZpChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zp', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 lxdh 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.lxdh')
    onLxdhChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'lxdh', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dzyx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.dzyx')
    onDzyxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dzyx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hyzk 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
     */
    @Watch('data.mz')
    onMzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'mz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hklx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.hklx')
    onHklxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hklx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jg 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.jg')
    onJgChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jg', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hjszd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.hjszd')
    onHjszdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hjszd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hjdz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.hjdz')
    onHjdzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hjdz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 csd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.csd')
    onCsdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'csd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 postaladdress 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.postaladdress')
    onPostaladdressChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'postaladdress', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sfdszn 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.sfdszn')
    onSfdsznChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sfdszn', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ahtc 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.ahtc')
    onAhtcChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ahtc', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rcxllx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.rcxllx')
    onRcxllxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rcxllx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimmajorsetypename 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pimmajorsetypename')
    onPimmajorsetypenameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimmajorsetypename', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmrcxlname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pcmrcxlname')
    onPcmrcxlnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmrcxlname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jkzk 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.jkzk')
    onJkzkChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jkzk', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 jlczz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.jlczz')
    onJlczzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'jlczz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zzmm 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.zzmm')
    onZzmmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zzmm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rtsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.rtsj')
    onRtsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rtsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rdsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.rdsj')
    onRdsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rdsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 yglx 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.yglx')
    onYglxChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'yglx', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ygzt 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.ygzt')
    onYgztChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ygzt', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 workstate 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.workstate')
    onWorkstateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'workstate', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rzqd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.rzqd')
    onRzqdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rzqd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.ormorgid')
    onOrmorgidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.ormorgname')
    onOrmorgnameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgsectorid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.ormorgsectorid')
    onOrmorgsectoridChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgsectorid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 ormorgsectorname 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.ormorgsectorname')
    onOrmorgsectornameChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'ormorgsectorname', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 rank 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.rank')
    onRankChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'rank', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.zw')
    onZwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gw 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.gw')
    onGwChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gw', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 zj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.zj')
    onZjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'zj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 cjgzsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
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
     * @memberof RYInfoForm
     */
    @Watch('data.tozjdate')
    onTozjdateChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'tozjdate', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dzjbjsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.dzjbjsj')
    onDzjbjsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dzjbjsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 dbdwsj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.dbdwsj')
    onDbdwsjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'dbdwsj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gzzt 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.gzzt')
    onGzztChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gzzt', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gzzz 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.gzzz')
    onGzzzChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gzzz', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gzbm 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.gzbm')
    onGzbmChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gzbm', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gzkssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.gzkssj')
    onGzkssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gzkssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 gzjssj 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.gzjssj')
    onGzjssjChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'gzjssj', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sgyy 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.sgyy')
    onSgyyChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sgyy', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonname2 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pimpersonname2')
    onPimpersonname2Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonname2', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonname3 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pimpersonname3')
    onPimpersonname3Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonname3', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 sftberp 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.sftberp')
    onSftberpChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'sftberp', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 hmd 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.hmd')
    onHmdChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'hmd', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 blacklistreasons 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.blacklistreasons')
    onBlacklistreasonsChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'blacklistreasons', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimpersonid3 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pimpersonid3')
    onPimpersonid3Change(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimpersonid3', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pcmrcxlid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pcmrcxlid')
    onPcmrcxlidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pcmrcxlid', newVal: newVal, oldVal: oldVal });
    }

    /**
     * 监控表单属性 pimmajorsetypeid 值
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof RYInfoForm
     */
    @Watch('data.pimmajorsetypeid')
    onPimmajorsetypeidChange(newVal: any, oldVal: any) {
        this.formDataChange({ name: 'pimmajorsetypeid', newVal: newVal, oldVal: oldVal });
    }


    /**
     * 重置表单项值
     *
     * @private
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof RYInfoForm
     */
    private resetFormData({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
        if (Object.is(name, 'rcxllx')) {
            this.onFormItemValueChange({ name: 'pimmajorsetypename', value: null });
            this.onFormItemValueChange({ name: 'pimmajorsetypeid', value: null });
        }
        if (Object.is(name, 'rcxllx')) {
            this.onFormItemValueChange({ name: 'pcmrcxlname', value: null });
            this.onFormItemValueChange({ name: 'pcmrcxlid', value: null });
        }
    }

    /**
      * 置空对象
      *
      * @param {any[]} args
      * @memberof EditForm
      */
    protected ResetData(_datas:any){
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
     * @private
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @memberof RYInfoForm
     */
    private formLogic({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
                





























        if (Object.is(name, '') || Object.is(name, 'zjlx')) {
            let ret = false;
            const _zjlx = this.data.zjlx;
            if (this.$verify.testCond(_zjlx, 'NOTEQ', '10')) {
                ret = true;
            }
            this.detailsModel.csrq.setDisabled(!ret);
        }

        if (Object.is(name, '') || Object.is(name, 'zjlx')) {
            let ret = false;
            const _zjlx = this.data.zjlx;
            if (this.$verify.testCond(_zjlx, 'NOTEQ', '10')) {
                ret = true;
            }
            this.detailsModel.xb.setDisabled(!ret);
        }



















        if (Object.is(name, '') || Object.is(name, 'rcxllx')) {
            let ret = false;
            const _rcxllx = this.data.rcxllx;
            if (this.$verify.testCond(_rcxllx, 'EQ', 'ZY')) {
                ret = true;
            }
            this.detailsModel.pimmajorsetypename.setVisible(ret);
        }





        if (Object.is(name, '') || Object.is(name, 'zzmm')) {
            let ret = false;
            const _zzmm = this.data.zzmm;
            if (this.$verify.testCond(_zzmm, 'EQ', '30')) {
                ret = true;
            }
            this.detailsModel.rtsj.setVisible(ret);
        }

        if (Object.is(name, '') || Object.is(name, 'zzmm')) {
            let ret = false;
            const _zzmm = this.data.zzmm;
            if (this.$verify.testCond(_zzmm, 'EQ', '10')) {
                ret = true;
            }
            this.detailsModel.rdsj.setVisible(ret);
        }






















        if (Object.is(name, '') || Object.is(name, 'ygzt')) {
            let ret = false;
            const _ygzt = this.data.ygzt;
            if (this.$verify.testCond(_ygzt, 'EQ', '130')) {
                ret = true;
            }
            this.detailsModel.sgyy.setVisible(ret);
        }





        if (Object.is(name, '') || Object.is(name, 'hmd')) {
            let ret = true;
            const _hmd = this.data.hmd;
            if (this.$verify.testCond(_hmd, 'NOTEQ', '1')) {
                ret = false;
            }
            this.rules.blacklistreasons.some((rule: any) => {
                if (rule.hasOwnProperty('required')) {
                    rule.required = ret;
                }
                return false;
            });
        }
        if (Object.is(name, '') || Object.is(name, 'hmd')) {
            let ret = false;
            const _hmd = this.data.hmd;
            if (this.$verify.testCond(_hmd, 'EQ', '1')) {
                ret = true;
            }
            this.detailsModel.blacklistreasons.setVisible(ret);
        }





        if(Object.is(name, 'ygbh')){
            const details: string[] = ['yglx'];
            this.updateFormItems('FillPersonType', this.data, details, true);
        }

        if(Object.is(name, 'zjhm')){
            const details: string[] = ['csrq', 'nj', 'xb'];
            this.updateFormItems('PersonUpdateInfo', this.data, details, true);
        }
    }

    /**
     * 表单值变化
     *
     * @private
     * @param {{ name: string, newVal: any, oldVal: any }} { name, newVal, oldVal }
     * @returns {void}
     * @memberof RYInfoForm
     */
    private formDataChange({ name, newVal, oldVal }: { name: string, newVal: any, oldVal: any }): void {
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
     * @private
     * @param {*} [data={}]
     * @param {string} [action]
     * @memberof RYInfoForm
     */
    private onFormLoad(data: any = {},action:string): void {
        if(Object.is(action,"save") || Object.is(action,"autoSave"))
        // 更新context的实体主键
        if(data.pimperson){
            Object.assign(this.context,{pimperson:data.pimperson})
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
     * @memberof RYInfoForm
     */
    protected fillForm(_datas: any = {},action:string): void {
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
     * @protected
     * @param {*} data
     * @memberof RYInfoForm
     */
    protected setFormEnableCond(data: any): void {
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
     * @private
     * @memberof RYInfoForm
     */
    private resetDraftFormStates(): void {
        const form: any = this.$refs.form;
        if (form) {
            form.resetFields();
        }
    }

    /**
     * 重置校验结果
     *
     * @memberof RYInfoForm
     */
    protected resetValidates(): void {
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
     * @memberof RYInfoForm
     */
    protected fillValidates(fieldErrors: any[]): void {
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
     * @memberof RYInfoForm
     */
    protected formValidateStatus(): boolean {
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
     * @memberof RYInfoForm
     */
    protected getValues(): any {
        return this.data;
    }

    /**
     * 表单项值变更
     *
     * @param {{ name: string, value: any }} $event
     * @returns {void}
     * @memberof RYInfoForm
     */
    protected onFormItemValueChange($event: { name: string, value: any }): void {
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
     * @memberof RYInfoForm
     */
    protected setDataItemValue(name: string, value: any): void {
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
     * @memberof RYInfoForm
     */
    protected groupUIActionClick($event: any): void {
        if (!$event) {
            return;
        }
        const item:any = $event.item;
    }

    /**
     * Vue声明周期(处理组件的输入属性)
     *
     * @memberof RYInfoForm
     */
    protected created(): void {
        this.afterCreated();
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof RYInfoForm
     */    
    protected afterCreated(){
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
                    this.loadDraft(data);
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
     * @memberof RYInfoForm
     */
    protected destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof RYInfoForm
     */
    protected afterDestroy() {
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
     * @memberof @memberof RYInfoForm
     */
    protected copy(arg: any = {}): void {
        this.loadDraft(arg);
    }

    /**
     *打印
     *@memberof @memberof RYInfoForm
     */
    protected print(){
        let _this:any = this;
        _this.$print({id:'form',popTitle:'人员信息（主编辑）'});
    }

    /**
     * 部件刷新
     *
     * @param {any[]} args
     * @memberof RYInfoForm
     */
    protected refresh(args: any[]): void {
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
     * @memberof RYInfoForm
     */
    protected autoLoad(arg: any = {}): void {
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
     * @private
     * @param {*} [opt={}]
     * @memberof RYInfoForm
     */
    private load(opt: any = {}): void {
        if(!this.loadAction){
            this.$Notice.error({ title: '错误', desc: 'PIMPERSONEditView视图表单loadAction参数未配置' });
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
     * @memberof RYInfoForm
     */
    protected loadDraft(opt: any = {}): void {
        if(!this.loaddraftAction){
            this.$Notice.error({ title: '错误', desc: 'PIMPERSONEditView视图表单loaddraftAction参数未配置' });
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
            if(data.pimperson){
                Object.assign(this.context,{pimperson:data.pimperson})
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
     * @memberof RYInfoForm
     */
    protected autoSave(opt: any = {}): void {
        if (!this.formValidateStatus()) {
            return;
        }
        const arg: any = { ...opt };
        const data = this.getValues();
        Object.assign(arg, data);
        const action: any = Object.is(data.srfuf, '1') ? this.updateAction : this.createAction;
        if(!action){
            let actionName:any = Object.is(data.srfuf, '1')?"updateAction":"createAction";
            this.$Notice.error({ title: '错误', desc: 'PIMPERSONEditView视图表单'+actionName+'参数未配置' });
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
     * @memberof RYInfoForm
     */
    protected async save(opt: any = {}, showResultInfo?: boolean, ifStateNext: boolean = true): Promise<any> {
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
                this.$Notice.error({ title: '错误', desc: 'PIMPERSONEditView视图表单'+actionName+'参数未配置' });
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
    * @private
    * @param {*} [opt={}]
    * @memberof EditForm
    */
    private remove(opt:Array<any> = [],showResultInfo?: boolean): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            if(!this.removeAction){
                this.$Notice.error({ title: '错误', desc: 'PIMPERSONEditView视图表单removeAction参数未配置' });
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
     * @memberof RYInfoForm
     */
    protected async wfstart(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            const _this: any = this;
            const arg: any = data[0];
            Object.assign(arg,{viewparams:this.viewparams});
            const post: Promise<any> = Object.is(arg.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
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
     * @memberof RYInfoForm
     */
    protected async wfsubmit(data: any,localdata?:any): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
        const _this: any = this;
        const arg: any = data[0];
        Object.assign(arg,{viewparams:this.viewparams});
        if (!arg.pimperson || Object.is(arg.pimperson, '')) {
            return;
        }
        const post: Promise<any> = Object.is(arg.srfuf, '1')?this.service.update(this.updateAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator):this.service.add(this.createAction,JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator);
        post.then((response:any) =>{
                const arg:any = response.data;
                if(this.viewparams){
                    Object.assign(arg,{viewparams:this.viewparams});
                }
                const result: Promise<any> = this.service.wfsubmit(_this.WFSubmitAction, JSON.parse(JSON.stringify(this.context)),arg, this.showBusyIndicator,localdata);
                result.then((response: any) => {
                    if (!response || response.status !== 200) {
                        if(response.data){
                            this.$Notice.error({ title: '', desc: '工作流提交失败, ' + response.data.message });
                        }
                        return;
                    }
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
     * @memberof RYInfoForm
     */
    protected updateFormItems(mode: string, data: any = {}, updateDetails: string[], showloading?: boolean): void {
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
     * @memberof RYInfoForm
     */
    protected onEnter($event: any): void {
    }

    /**
     * 保存并退出
     *
     * @param {any[]} args
     * @memberof RYInfoForm
     */
    protected saveAndExit(data:any[]):Promise<any>{
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
     * @memberof RYInfoForm
     */
    protected saveAndNew(data:any[]):Promise<any>{
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
     * @memberof RYInfoForm
     */
    protected removeAndExit(data:any[]):Promise<any>{
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
    * @memberof RYInfoForm
    */
    protected drdatasaved($event:any){
        let _this = this;
        this.drcounter--;
        if(this.drcounter > 0){
            return;
        }
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

    /**
     * 新建默认值
     * @memberof RYInfoForm
     */
    public createDefault(){                    
        if (this.data.hasOwnProperty('ormorgid')) {
            this.data['ormorgid'] = this.context['SRFORGID'];
        }
        if (this.data.hasOwnProperty('ormorgname')) {
            this.data['ormorgname'] = this.context['SRFORGNAME'];
        }
        if (this.data.hasOwnProperty('ormorgsectorid')) {
            this.data['ormorgsectorid'] = 'DEFAULT';
        }
    }

    /**
     * 更新默认值
     * @memberof RYInfoForm
     */
    public updateDefault(){                    
        if (this.data.hasOwnProperty('pimpersonid2') && !this.data.pimpersonid2) {
            this.data['pimpersonid2'] = this.viewparams['srfkey'];
        }
    }

    
}
</script>

<style lang='less'>
@import './ryinfo-form-form.less';
</style>