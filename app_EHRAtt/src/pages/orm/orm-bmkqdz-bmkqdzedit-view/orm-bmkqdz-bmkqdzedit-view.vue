<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmBmkqdzBMKQDZEditViewBase from './orm-bmkqdz-bmkqdzedit-view-base.vue';

import view_form from '@widgets/orm-bmkqdz/main-2-form/main-2-form.vue';

/**
 * 部门考勤地址
 *
 * @export
 * @class OrmBmkqdzBMKQDZEditView
 * @extends {OrmBmkqdzBMKQDZEditViewBase}
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
export default class OrmBmkqdzBMKQDZEditView extends OrmBmkqdzBMKQDZEditViewBase { }
</script>