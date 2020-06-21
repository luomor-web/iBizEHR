<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParKhzcmxEditViewBase from './par-khzcmx-edit-view-base.vue';

import view_form from '@widgets/par-khzcmx/main-form/main-form.vue';

/**
 * 考核模板明细
 *
 * @export
 * @class ParKhzcmxEditView
 * @extends {ParKhzcmxEditViewBase}
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
export default class ParKhzcmxEditView extends ParKhzcmxEditViewBase { }
</script>