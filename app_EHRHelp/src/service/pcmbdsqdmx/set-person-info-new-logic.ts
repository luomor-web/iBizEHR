import { Http,Util } from '@/utils';
import SetPersonInfoNewLogicBase from './set-person-info-new-logic-base';

/**
 * 设置职级、组织、部门、员工编号、职务、新职级
 *
 * @export
 * @class SetPersonInfoNewLogic
 */
export default class SetPersonInfoNewLogic extends SetPersonInfoNewLogicBase{

    /**
     * Creates an instance of  SetPersonInfoNewLogic
     * 
     * @param {*} [opts={}]
     * @memberof  SetPersonInfoNewLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}