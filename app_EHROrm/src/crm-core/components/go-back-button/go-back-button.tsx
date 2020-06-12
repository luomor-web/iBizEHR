import { Vue, Component } from 'vue-property-decorator';
import './go-back-button.less';

/**
 * 通用级工具栏返回
 *
 * @export
 * @class GoBackButton
 * @extends {Vue}
 */
@Component({})
export class GoBackButton extends Vue {

    /**
     * 路由返回
     *
     * @protected
     * @memberof GoBackButton
     */
    protected back(): void {
        this.$router.back();
    }

    /**
     * 绘制返回按钮
     *
     * @returns {*}
     * @memberof GoBackButton
     */
    public render(): any {
        return <div class="view-go-back" on-click={() => this.back()}>
            <i class="el-icon-back"/>
        </div>;
    }

}