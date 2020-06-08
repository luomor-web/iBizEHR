/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main_2Model
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATE',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimrewardpunishmentid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimrewardpunishmentname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'lx',
        prop: 'lx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimrewardpunishmentname',
        prop: 'pimrewardpunishmentname',
        dataType: 'TEXT',
      },
      {
        name: 'jcjb',
        prop: 'jcjb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jlsj',
        prop: 'jlsj',
        dataType: 'DATE',
      },
      {
        name: 'jcje',
        prop: 'jcje',
        dataType: 'FLOAT',
      },
      {
        name: 'department',
        prop: 'department',
        dataType: 'TEXT',
      },
      {
        name: 'cflx',
        prop: 'cflx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yxqjsrq',
        prop: 'yxqjsrq',
        dataType: 'DATE',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jcsj',
        prop: 'jcsj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimrewardpunishmentid',
        prop: 'pimrewardpunishmentid',
        dataType: 'GUID',
      },
      {
        name: 'pimrewardpunishment',
        prop: 'pimrewardpunishmentid',
        dataType: 'FONTKEY',
      },
    ]
  }

}