import { Http,Util } from '@/utils';
import SetSJLogicBase from './set-sj-logic-base';

/**
 * 设置其他时间的值为生效日期
 *
 * @export
 * @class SetSJLogic
 */
export default class SetSJLogic extends SetSJLogicBase{

    /**
     * Creates an instance of  SetSJLogic
     * 
     * @param {*} [opts={}]
     * @memberof  SetSJLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}