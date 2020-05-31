<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMACHIEVEMENTSEditViewBase from './pimachievementsedit-view-base.vue';

import view_form from '@widgets/pim-achievements/main-form/main-form.vue';

/**
 * 绩效信息编辑视图
 *
 * @export
 * @class PIMACHIEVEMENTSEditView
 * @extends {PIMACHIEVEMENTSEditViewBase}
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
export default class PIMACHIEVEMENTSEditView extends PIMACHIEVEMENTSEditViewBase { }
</script>