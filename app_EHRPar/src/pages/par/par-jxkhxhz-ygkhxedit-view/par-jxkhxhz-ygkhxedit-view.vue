<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParJxkhxhzYGKHXEditViewBase from './par-jxkhxhz-ygkhxedit-view-base.vue';

import view_form from '@widgets/par-jxkhxhz/ygkhx-form/ygkhx-form.vue';

/**
 * 员工考核内容及评分汇总
 *
 * @export
 * @class ParJxkhxhzYGKHXEditView
 * @extends {ParJxkhxhzYGKHXEditViewBase}
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
export default class ParJxkhxhzYGKHXEditView extends ParJxkhxhzYGKHXEditViewBase { }
</script>