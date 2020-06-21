<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDepartXQHZEditViewBase from './trm-depart-xqhzedit-view-base.vue';

import view_form from '@widgets/trm-depart/main-2-form/main-2-form.vue';

/**
 * 需求汇总
 *
 * @export
 * @class TrmDepartXQHZEditView
 * @extends {TrmDepartXQHZEditViewBase}
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
export default class TrmDepartXQHZEditView extends TrmDepartXQHZEditViewBase { }
</script>