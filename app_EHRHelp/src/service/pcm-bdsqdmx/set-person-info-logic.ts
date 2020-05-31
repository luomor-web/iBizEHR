import { Http,Util } from '@/utils';
import SetPersonInfoLogicBase from './set-person-info-logic-base';

/**
 * 设置职级、组织、部门、员工编号、职务
 *
 * @export
 * @class SetPersonInfoLogic
 */
export default class SetPersonInfoLogic extends SetPersonInfoLogicBase{

    /**
     * Creates an instance of  SetPersonInfoLogic
     * 
     * @param {*} [opts={}]
     * @memberof  SetPersonInfoLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}