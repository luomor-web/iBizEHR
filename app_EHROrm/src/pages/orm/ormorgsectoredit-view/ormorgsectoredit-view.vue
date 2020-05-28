<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTOREditViewBase from './ormorgsectoredit-view-base.vue';

import view_form from '@widgets/orm-orgsector/main-form/main-form.vue';

/**
 * 部门
 *
 * @export
 * @class ORMORGSECTOREditView
 * @extends {ORMORGSECTOREditViewBase}
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
export default class ORMORGSECTOREditView extends ORMORGSECTOREditViewBase { }
</script>