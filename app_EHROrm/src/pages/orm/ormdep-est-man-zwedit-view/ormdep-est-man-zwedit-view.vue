<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDepEstManZWEditViewBase from './ormdep-est-man-zwedit-view-base.vue';

import view_form from '@widgets/ormdep-est-man/zwbzmx-form/zwbzmx-form.vue';

/**
 * 职务编制明细
 *
 * @export
 * @class ORMDepEstManZWEditView
 * @extends {ORMDepEstManZWEditViewBase}
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
export default class ORMDepEstManZWEditView extends ORMDepEstManZWEditViewBase { }
</script>