<template>
  <div class="app-studioaction" v-if="isDevMode">
        <div v-show="sdc.isShowTool" class="studio-config-container">
            <div class="title">
                {{viewTitle}}
            </div>
            <div class="actions">
                <div class="action-item" :title="$t('components.appStudioAction.configTitle')">
                    <i-button type="text" ghost @click="configView()">{{$t('components.appStudioAction.configButton')}}</i-button>
                </div>
                <div class="action-item" :title="$t('components.appStudioAction.issueTitle')">
                    <i-button type="text" ghost @click="createIssues()">{{$t('components.appStudioAction.issueButton')}}</i-button>
                </div>
            </div>
        </div>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Inject, Prop } from "vue-property-decorator";
import { Environment } from '@/environments/environment';
import { StudioActionUtil } from '@/utils';

@Component({
})
export default class AppStudioAction extends Vue {

    /**
     * 视图标题
     *
     * @type {string}
     * @memberof AppStudioAction
     */ 
    @Prop() public viewTitle!:string;

    /**
     * 视图名称
     *
     * @type {string}
     * @memberof AppStudioAction
     */ 
    @Prop() public viewName!:string;

    /**
     * 是否开发为环境
     *
     * @type {boolean}
     * @memberof AppStudioAction
     */   
    public isDevMode:boolean = Environment.devMode;

    /**
     * 配置平台操作控制器
     *
     * @type {StudioActionController}
     * @memberof AppStudioAction
     */
    public sdc: StudioActionUtil = StudioActionUtil.getInstance();
    
    /**
     * 触发配置
     *
     * @protected
     * @memberof AppStudioAction
     */
    protected configView(): void {
        this.sdc.openStudioConfigView(this.viewName);
    }

    /**
     * 新建issues
     *
     * @protected
     * @memberof AppStudioAction
     */
    protected createIssues(): void {
        this.sdc.createdIssues(this.viewName);
    }

}
</script>

<style lang="less">
@import "./app-studioaction.less";
</style>