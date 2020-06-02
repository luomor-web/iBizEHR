<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTStopTimeSelectEditViewBase from './pimcontractstop-time-select-edit-view-base.vue';

import view_form from '@widgets/pim-contract/stoptime-select-form/stoptime-select-form.vue';

/**
 * 合同信息编辑视图
 *
 * @export
 * @class PIMCONTRACTStopTimeSelectEditView
 * @extends {PIMCONTRACTStopTimeSelectEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMCONTRACTStopTimeSelectEditView extends PIMCONTRACTStopTimeSelectEditViewBase { }
</script>