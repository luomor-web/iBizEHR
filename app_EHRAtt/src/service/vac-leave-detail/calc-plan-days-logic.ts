import { Http,Util } from '@/utils';
import CalcPlanDaysLogicBase from './calc-plan-days-logic-base';

/**
 * 计算计划请假天数
 *
 * @export
 * @class CalcPlanDaysLogic
 */
export default class CalcPlanDaysLogic extends CalcPlanDaysLogicBase{

    /**
     * Creates an instance of  CalcPlanDaysLogic
     * 
     * @param {*} [opts={}]
     * @memberof  CalcPlanDaysLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}