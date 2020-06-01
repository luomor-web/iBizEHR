<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaceTypeEditViewBase from './vac-leace-type-edit-view-base.vue';

import view_form from '@widgets/vac-leace-type/main-form/main-form.vue';

/**
 * 休假类型管理编辑视图
 *
 * @export
 * @class VacLeaceTypeEditView
 * @extends {VacLeaceTypeEditViewBase}
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
export default class VacLeaceTypeEditView extends VacLeaceTypeEditViewBase { }
</script>