/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimachievementsid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimachievementsname',
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
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimachievementsname',
        prop: 'pimachievementsname',
        dataType: 'TEXT',
      },
      {
        name: 'khlx',
        prop: 'khlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jd',
        prop: 'jd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'yd',
        prop: 'yd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'khdf',
        prop: 'khdf',
        dataType: 'DECIMAL',
      },
      {
        name: 'khjl',
        prop: 'khjl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'xmjb',
        prop: 'xmjb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'dj',
        prop: 'dj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimachievementsid',
        prop: 'pimachievementsid',
        dataType: 'GUID',
      },
      {
        name: 'pimachievements',
        prop: 'pimachievementsid',
        dataType: 'FONTKEY',
      },
    ]
  }

}