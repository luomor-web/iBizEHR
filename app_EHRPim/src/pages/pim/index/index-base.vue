<script lang='tsx'>
import { Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { IndexViewBase } from '@/crm-core';

/**
 * EHR—基础管理基类
 *
 * @export
 * @class IndexBase
 * @extends {IndexViewBase}
 */
export default class IndexBase extends IndexViewBase {

	/**
	 * 视图标识
	 *
	 * @type {string}
     * @protected
	 * @memberof IndexBase
	 */
	protected viewtag: string = '9b447b0f9964dfe3ff240487c1d86342';

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof IndexBase
     */
    public model: any = {
        srfTitle: 'EHR—基础管理',
        srfCaption: 'app.views.index.caption',
        srfSubCaption: '',
        dataInfo: ''
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof IndexBase
     */
    public containerModel: any = {
        view_appmenu: { name: 'appmenu', type: 'APPMENU' },
    };


    public render(): any {
        return (<div class="app-container">
            <app-layout viewName="index" viewTitle="EHR—基础管理" className={{ index_view: true }}>
        <template slot="headerLeft">
          <div class="app-header-left">
            <img class="logo" src="./assets/img/logo.png" />
            <div class="app-name">{this.$t(this.model.srfCaption)}</div>
          </div>
        </template>
        <template slot="headerRight">
          <div class="app-header-right">
            <app-top-menus />
          </div>
        </template>
        <template slot="content">
          <div class="crm-app-content">
            <div class="inedx-app-menus">
          <view_appmenu
            viewState={this.viewState}
            viewparams={this.viewparams}
            context={this.context}
            showBusyIndicator={true}
            on-menus-change={(menus: any[]) => this.appMenusChange(menus)}
            name="appmenu"
            ref="appmenu"
          />

            </div>
            <div class="content" style="width: calc(100% - 240px)">
              <router-view></router-view>
            </div>
          </div>
        </template>
      </app-layout>

        </div>);
    }
}
</script>

<style lang='less'>
@import './index.less';
</style>