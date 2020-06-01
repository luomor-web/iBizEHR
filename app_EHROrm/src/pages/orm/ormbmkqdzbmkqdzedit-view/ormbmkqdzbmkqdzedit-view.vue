<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMBMKQDZBMKQDZEditViewBase from './ormbmkqdzbmkqdzedit-view-base.vue';

import view_form from '@widgets/orm-bmkqdz/main-2-form/main-2-form.vue';

/**
 * 部门考勤地址
 *
 * @export
 * @class ORMBMKQDZBMKQDZEditView
 * @extends {ORMBMKQDZBMKQDZEditViewBase}
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
export default class ORMBMKQDZBMKQDZEditView extends ORMBMKQDZBMKQDZEditViewBase { }
</script>