import { Http,Util } from '@/utils';
import ModInfoLogicBase from './mod-info-logic-base';

/**
 * 更新员工信息表中组织、部门信息
 *
 * @export
 * @class ModInfoLogic
 */
export default class ModInfoLogic extends ModInfoLogicBase{

    /**
     * Creates an instance of  ModInfoLogic
     * 
     * @param {*} [opts={}]
     * @memberof  ModInfoLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}