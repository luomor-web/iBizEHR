<template>
   <div class='show-type'>
      <button-group v-show="!showTypeDir">
            <i-button  class="collapse-btn" type="primary" @click="clickCollapse('left')">
                <icon type="ios-arrow-back"/>
            </i-button>
      </button-group>
      <button-group v-show="showTypeDir">
          <el-tooltip :content="$t('components.appBuild.custom')">
              <i-button icon="md-build" type="primary" @click="handleClick"></i-button>
          </el-tooltip>
          <i-button class="collapse-btn" type="primary" @click="clickCollapse('right')">
              <icon type="ios-arrow-forward"/>
          </i-button>
      </button-group>  
      </div>
</template>

<script lang="ts">
import {Vue, Component, Prop, Watch} from 'vue-property-decorator';


@Component({
})
export default class AppBuild extends Vue {

    /**
     * 工具栏伸缩
     *
     * @protected
     * @type {boolean}
     * @memberof AppBuild
     */
    public showTypeDir: boolean = false;


    /**
     * 点击伸缩
     *
     * @param {*} type
     * @memberof AppBuild
     */
    public clickCollapse(type: string) {
        this.showTypeDir = Object.is(type, 'left') ? true : false;
    }

    /**
     * 工具点击
     * 
     *@memberof AppBuild
     */
    public handleClick(){
      this.$emit("handleClick")
    }
}
</script>

<style lang="less">
@import './app-build.less';
</style>