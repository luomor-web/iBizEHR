import { Vue, Component } from 'vue-property-decorator';
import './app-user-info.less';

/**
 * 用户信息展示
 *
 * @export
 * @class AppUserInfo
 * @extends {Vue}
 */
@Component({})
export class AppUserInfo extends Vue {

    /**
     * 绘制用户信息内容
     *
     * @returns {*}
     * @memberof AppUserInfo
     */
    public render(): any {
        return <div class="crm-app-user-info">
            <div class="user-head-sculpture">
                埃
            </div>
            <span>
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAQAAAAUCAYAAACqJ5zlAAAAN0lEQVQoU2PsmLzCk5Hh/0wGBgaG/wyM6Yydk5c/+s/AIAsSYGRgeIwpgKEFpBQZMJIhMIzcAQAhOjo7JEcKTQAAAABJRU5ErkJggg=="></img>
            </span>
        </div>;
    }

}