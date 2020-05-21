import { Http,Util } from '@/utils';
import PCMNORecyclingLibraryServiceBase from './pcmnorecycling-library-service-base';


/**
 * 员工编号回收库服务对象
 *
 * @export
 * @class PCMNORecyclingLibraryService
 * @extends {PCMNORecyclingLibraryServiceBase}
 */
export default class PCMNORecyclingLibraryService extends PCMNORecyclingLibraryServiceBase {

    /**
     * Creates an instance of  PCMNORecyclingLibraryService.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMNORecyclingLibraryService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}