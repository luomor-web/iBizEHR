<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonSYJXEditViewBase from './pim-person-syjxedit-view-base.vue';

import view_form from '@widgets/pim-person/jxsyedit-form-form/jxsyedit-form-form.vue';

/**
 * 人员信息
 *
 * @export
 * @class PimPersonSYJXEditView
 * @extends {PimPersonSYJXEditViewBase}
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
export default class PimPersonSYJXEditView extends PimPersonSYJXEditViewBase { }
</script>