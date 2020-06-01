<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacSynjcxEditViewBase from './vac-synjcx-edit-view-base.vue';

import view_form from '@widgets/vac-synjcx/main-form/main-form.vue';

/**
 * 年休假查询编辑视图
 *
 * @export
 * @class VacSynjcxEditView
 * @extends {VacSynjcxEditViewBase}
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
export default class VacSynjcxEditView extends VacSynjcxEditViewBase { }
</script>