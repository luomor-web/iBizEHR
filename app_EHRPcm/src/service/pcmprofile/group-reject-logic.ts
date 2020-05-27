import { Http,Util } from '@/utils';
import GroupRejectLogicBase from './group-reject-logic-base';

/**
 * 总部审批-拒绝
 *
 * @export
 * @class GroupRejectLogic
 */
export default class GroupRejectLogic extends GroupRejectLogicBase{

    /**
     * Creates an instance of  GroupRejectLogic
     * 
     * @param {*} [opts={}]
     * @memberof  GroupRejectLogic
     */
    constructor(opts: any = {}) {
        super(opts);
    }

}