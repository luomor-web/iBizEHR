import { Http,Util } from '@/utils';
import EnsureHighestTechLogicBase from './ensure-highest-tech-logic-base';

/**
 * 确认唯一最高职称
 *
 * @export
 * @class EnsureHighestTechLogic
 */
export default class EnsureHighestTechLogic extends EnsureHighestTechLogicBase{

    /**
     * Creates an instance of  EnsureHighestTechLogic
     * 
     * @param {*} [opts={}]
     * @memberof  EnsureHighestTechLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}