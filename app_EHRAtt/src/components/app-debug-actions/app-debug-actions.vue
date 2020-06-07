<template>
<div class="app-debug-actions">
    <div class="actions">
        <button-group vertical>
            <i-button :title="$t('components.appDebugActions.button')" :type="sdc.isShowTool ? 'warning' : 'info'" ghost @click="() => sdc.showToolChange()" :icon="sdc.isShowTool ? 'ios-bug' : 'ios-bug-outline'" ></i-button>
        </button-group>
    </div>
    <div class="show-buttons">
        <div class="button"><i class="ivu-icon ivu-icon-ios-arrow-down" /></div>
    </div>
</div>
</template>
<script lang = 'ts'>
import { Vue, Component } from 'vue-property-decorator';
import { StudioActionUtil } from '@/utils';
import { Environment } from '@/environments/environment';
/**
 * 开发模式控制行为组
 *
 * @export
 * @class AppDebugActions
 * @extends {Vue}
 */
@Component({
})
export default class AppDebugActions extends Vue {

    /**
     * 配置平台操作控制器
     *
     * @type {StudioActionController}
     * @memberof AppDebugActions
     */
    public sdc: StudioActionUtil = StudioActionUtil.getInstance();

}
</script>
<style lang = "less">
@import "./app-debug-actions.less";
</style>