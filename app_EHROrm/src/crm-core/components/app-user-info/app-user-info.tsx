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
     * 用户名 
     *
     * @memberof AppUserInfo
     */
    public username = "埃";

    /**
     * vue  生命周期
     *
     * @memberof AppUserInfo
     */
    public mounted() {
        if(this.$store.getters.getAppData()){
            if(this.$store.getters.getAppData().context && this.$store.getters.getAppData().context.srfusername){
              let _username = this.$store.getters.getAppData().context.srfusername;
              this.username = _username.substr(0,1).toUpperCase();
            }
        }
    }

    /**
     * 绘制用户信息内容
     *
     * @returns {*}
     * @memberof AppUserInfo
     */
    public render(): any {
        return <div class="crm-app-user-info">
            <div class="user-head-sculpture">
                {this.username}
            </div>
            <span>
                <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAQAAAAUCAYAAACqJ5zlAAAAN0lEQVQoU2PsmLzCk5Hh/0wGBgaG/wyM6Yydk5c/+s/AIAsSYGRgeIwpgKEFpBQZMJIhMIzcAQAhOjo7JEcKTQAAAABJRU5ErkJggg=="></img>
            </span>
        </div>;
    }

}