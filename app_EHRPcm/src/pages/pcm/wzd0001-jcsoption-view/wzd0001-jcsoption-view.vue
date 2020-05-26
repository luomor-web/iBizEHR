<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import WZD0001JCSOptionViewBase from './wzd0001-jcsoption-view-base.vue';

import view_form from '@widgets/wzd0001/jcsyj-form/jcsyj-form.vue';

/**
 * 局总部初审
 *
 * @export
 * @class WZD0001JCSOptionView
 * @extends {WZD0001JCSOptionViewBase}
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
export default class WZD0001JCSOptionView extends WZD0001JCSOptionViewBase { }
</script>