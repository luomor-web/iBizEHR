import { Http,Util } from '@/utils';
import PersonUpdateInfoLogicBase from './person-update-info-logic-base';

/**
 * 根据证件号更改出生日期、性别、年龄
 *
 * @export
 * @class PersonUpdateInfoLogic
 */
export default class PersonUpdateInfoLogic extends PersonUpdateInfoLogicBase{

    /**
     * Creates an instance of  PersonUpdateInfoLogic
     * 
     * @param {*} [opts={}]
     * @memberof  PersonUpdateInfoLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}