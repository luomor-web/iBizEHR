/**
 * 视图状态
 *
 * @interface ViewState
 */
interface ViewState {

    /**
     * 部件标识
     *
     * @type {string}
     * @memberof ViewState
     */
    tag: string;

    /**
     * 触发行为
     *
     * @type {('load' | 'save' | 'remove' | 'autoload' | 'loaddraft' | 'filter' | 'refresh_parent' | any)}
     * @memberof ViewState
     */
    action: 'load' | 'save' | 'remove' | 'autoload' | 'loaddraft' | 'filter' | 'refresh_parent' | any;

    /**
     * 数据
     *
     * @type {*}
     * @memberof ViewState
     */
    data?: any;
}