<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgsectorBMKQSZEditViewBase from './orm-orgsector-bmkqszedit-view-base.vue';

import view_form from '@widgets/orm-orgsector/bmkqsz-form/bmkqsz-form.vue';

/**
 * 部门管理
 *
 * @export
 * @class OrmOrgsectorBMKQSZEditView
 * @extends {OrmOrgsectorBMKQSZEditViewBase}
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
export default class OrmOrgsectorBMKQSZEditView extends OrmOrgsectorBMKQSZEditViewBase { }
</script>